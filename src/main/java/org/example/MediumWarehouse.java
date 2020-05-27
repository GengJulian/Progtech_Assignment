package org.example;

import java.util.ArrayList;
import java.util.List;

public class MediumWarehouse extends Warehouse {
    String name;
    int capacity = 500;
    Enum type = WarehouseTypes.medium;
    List<Item> stockpile = new ArrayList<Item>();
    List<Supplier> suppliers = new ArrayList<Supplier>();

    public MediumWarehouse(String name) {
        super(name);
    }


    @Override
    public Item getItem(String itemName) throws InterruptedException {
        for (Item item : stockpile){
            if (item.name == itemName){
                stockpile.remove(item);
                return item;
            }
            Thread.sleep(20000);
        }
        return null;
    }

    @Override
    public void orderSupply(Order order) {

    }
}
