package org.example;

import java.util.List;

public class WarehouseAdapter extends Warehouse{
    OutsiderWarehouse adaptee;
    public WarehouseAdapter(OutsiderWarehouse adaptee) {
        super(adaptee.name,WarehouseTypes.outsider);
        super.stockpile = adaptee.cargo();
        super.suppliers = adaptee.suppliers();
        this.adaptee = adaptee;
    }

    @Override
    public Item getItem(String itemName) throws InterruptedException {
        Item outsiderItem = adaptee.getCargoItem();
        outsiderItem.price += 10;
        return outsiderItem;
    }

    @Override
    public Item getItem(Order itemorder) throws InterruptedException {
        for (Item item : stockpile){
            if (item.name == itemorder.itemName && item.type == itemorder.itemType){
                stockpile.remove(item);
                return item;
            }
            Thread.sleep(40000);
        }
        if(itemorder.quantity<=(capacity-super.stockpile.size())) {
            notifySuppliers(itemorder);
            System.out.println("Nincs raktáron a kívánt tárgy!\n Folyamatban a rendelés!");
        }
        return null;
    }

    @Override
    public void orderSupply(Order order) {
        adaptee.RefulStock();
    }

    @Override
    public void registerSupplier(Supplier supplier) {
        if(supplier==null) throw new NullPointerException("Null Observer");
        if(!suppliers.contains(supplier)) suppliers.add(supplier);
    }

    @Override
    public void unregisterSupplier(Supplier supplier) {
        suppliers.remove(supplier);
    }

    @Override
    public void notifySuppliers(Order itemorder) {
        for (Supplier supplier : super.suppliers){
            if (supplier.supplierType == itemorder.itemType){
                supplier.update(itemorder,this);
                break;
            }
        }
    }

    @Override
    public void receiveSupply(List<Item> supply) {
        super.stockpile.addAll(supply);
    }
}
