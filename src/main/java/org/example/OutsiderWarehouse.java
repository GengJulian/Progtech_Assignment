package org.example;

import java.util.ArrayList;
import java.util.List;

public class OutsiderWarehouse {
    String name;
    WarehouseTypes type;
    int capacity;
    List<Item> cargo = new ArrayList<Item>();
    List<Supplier> suppliers = new ArrayList<Supplier>();

    public OutsiderWarehouse(String name,WarehouseTypes type){
        this.name = name;
        this.type = type;
    }

    public void listStockpile(){
        System.out.println("Items in "+this.name);
        for(Item item : cargo){
            System.out.println(item.toString());
        }
    }

    public void listSuppliers(){
        System.out.println("All the suppliers ");
        for (Supplier supplier : suppliers ){
            System.out.println(supplier.toString());
        }
    }


    public Item getCargoItem(Order itemorder) throws InterruptedException {
        for (Item item : cargo){
            if (item.name == itemorder.itemName && item.type == itemorder.itemType){
                cargo.remove(item);
                return item;
            }
            Thread.sleep(40000);
        }
        return null;
    }

    public List<Item> getItem(Order itemorder) throws InterruptedException {
        List<Item> orderedItems = new ArrayList<>();
        for (Item item : cargo){
            if (item.name == itemorder.itemName && item.type == itemorder.itemType ){
                orderedItems.add(item);
                cargo.remove(item);
                itemorder.quantity--;
            }
            if(itemorder.quantity == 0)
                return orderedItems;
            Thread.sleep(80000);
        }

        if(itemorder.quantity<=(capacity-cargo.size())) {
            System.out.println("Nincs raktáron a kívánt tárgy!\n Folyamatban a rendelés!");
        }
        return orderedItems;
    }


    public void RefulStock(Order order) {


    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "name=" + name + '\'' +
                ", type=" + type +'\'' +
                ", capacity="+capacity+
                '}';
    }


}
