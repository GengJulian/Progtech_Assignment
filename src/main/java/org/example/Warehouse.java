package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Warehouse {
    String name;
    List<Item> stockpile = new ArrayList<Item>();
    List<Supplier> suppliers = new ArrayList<Supplier>();

    public void listStockpile(){
        System.out.println("All the items in the warehouse:");
        for(Item item : stockpile){
            System.out.println(item.toString());
        }
    }

    public void listSuppliers(){
        System.out.println("All the suppliers ");
        for (Supplier supplier : suppliers ){
            System.out.println(supplier.toString());
        }
    }

    public void getItem(){}

    public void orderSupply(){}

    public void registerSupplier(Supplier supplier){
        this.suppliers.add(supplier);
    }

}
