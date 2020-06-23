package org.example;

import java.util.ArrayList;
import java.util.Iterator;
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

    public int numberOfSpecificItem(String itemName){
        int numberOfItem = 0;
        for (int i = 0;i<stockpile.size();i++){
            if(stockpile.get(i).name == itemName)
                numberOfItem++;
        }
        return numberOfItem;
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

    public List<Item> getItem(Order itemorder)  {
        Iterator it = stockpile.iterator();
        List<Item> orderedItems = new ArrayList<>();
        while(it.hasNext()){
            Item item =(Item)it.next();
            if (item.name == itemorder.itemName && item.type == itemorder.itemType ){
                orderedItems.add(item);
                it.remove();
            }
            if(orderedItems.size() == itemorder.quantity)
                return orderedItems;
        }

        if(itemorder.quantity<=(capacity-stockpile.size())) {
            notifySuppliers(itemorder);
            System.out.println("Nincs raktáron a kívánt tárgy!\n Folyamatban a rendelés!");
        }
        return orderedItems;
    }

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
