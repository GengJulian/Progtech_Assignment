package org.example;

import java.util.List;


public class LargeWarehouse extends Warehouse{

    public LargeWarehouse(String name) {
        super(name,WarehouseTypes.large);
        capacity = 500;
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

    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "name=" + name + '\'' +
                ", type=" + type +'\'' +
                ", capacity="+capacity+
                '}';
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
