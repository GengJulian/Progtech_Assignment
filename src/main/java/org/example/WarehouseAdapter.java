package org.example;

import java.util.List;

public class WarehouseAdapter extends Warehouse{
    OutsiderWarehouse adaptee;
    public WarehouseAdapter(OutsiderWarehouse adaptee) {
        super(adaptee.name,WarehouseTypes.outsider);
        super.stockpile = adaptee.cargo;
        super.suppliers = adaptee.suppliers;
        this.adaptee = adaptee;
    }

    @Override
    public Item getItem(Order itemorder) throws InterruptedException {
        Item outsiderItem = adaptee.getCargoItem(itemorder);
        outsiderItem.price += 10;
        return outsiderItem;
    }


    @Override
    public void orderSupply(Order order) {
        adaptee.RefulStock(order);
    }

    @Override
    public void registerSupplier(Supplier supplier) {
        if(supplier==null) throw new NullPointerException("Null Observer");
        if(!suppliers.contains(supplier)) suppliers.add(supplier);
    }

    @Override
    public void unregisterSupplier(String supplierName,ItemTypes supplierType) {
        for(Supplier supplier : suppliers){
            if(supplier.getSupplierName() == supplierName && supplier.getType().equals(supplierType)){
                suppliers.remove(supplier);
            }
        }
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
