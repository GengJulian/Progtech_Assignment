package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SmallWarehouse extends Warehouse{

    boolean changed;

    public SmallWarehouse(String name) {
        super(name,WarehouseTypes.small);
        super.capacity = 200;
    }

    @Override
    public List<Item> getItem(Order itemorder)  {
        Iterator it = stockpile.iterator();
        List<Item> orderedItems = new ArrayList<>();
        while(it.hasNext()){
            Item item =(Item)it.next();
            if (item.name == itemorder.itemName && item.type == itemorder.itemType ){
                orderedItems.add(item);
                //stockpile.remove(item);
                it.remove();
            }
            if(orderedItems.size() == itemorder.quantity)
                return orderedItems;
        }

        if(itemorder.quantity<=(capacity-super.stockpile.size())) {
            notifySuppliers(itemorder);
            System.out.println("Nincs raktáron a kívánt tárgy!\n Folyamatban a rendelés!");
        }
        return orderedItems;
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
                "name=" + super.name + '\'' +
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
