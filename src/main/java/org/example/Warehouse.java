package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Warehouse implements Subject{
    String name;
    WarehouseTypes type;
    int capacity;
    List<Item> stockpile = new ArrayList<Item>();
    List<Supplier> suppliers = new ArrayList<Supplier>();

    public Warehouse(String name,WarehouseTypes type){
        this.name = name;
        this.type = type;
    }

    public void listStockpile(){
        System.out.println("Items in "+this.name);
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

    public abstract Item getItem(Order itemorder) throws InterruptedException;

    public abstract  void orderSupply(Order order);



    @Override
    public String toString() {
        return "Warehouse{" +
                "name=" + name + '\'' +
                ", type=" + type +'\'' +
                ", capacity="+capacity+
                '}';
    }

}
