package org.example;

import java.util.ArrayList;
import java.util.Iterator;
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
