package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class LargeWarehouse extends Warehouse{

    public LargeWarehouse(String name) {
        super(name,WarehouseTypes.large);
        capacity = 500;
    }



    @Override
    public void orderSupply(Order itemorder) {
        if(itemorder.quantity<=(capacity-super.stockpile.size())) {
            notifySuppliers(itemorder);
        }else{
            System.out.println(String.format("%f is full!",this.name));
        }
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
