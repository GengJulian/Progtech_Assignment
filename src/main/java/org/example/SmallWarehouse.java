package org.example;

import java.util.ArrayList;
import java.util.List;

public class SmallWarehouse extends Warehouse{
    String name;
    int capacity = 200;
    Enum type = WarehouseTypes.small;
    List<Item> stockpile = new ArrayList<Item>();
    List<Supplier> suppliers = new ArrayList<Supplier>();

    public SmallWarehouse(String name) {
        super(name);
    }


    @Override
    public Item getItem(String itemName) {
        for (Item item : stockpile){
            if (item.name == itemName){
                stockpile.remove(item);
                return item;
            }
        }
        return null;
    }

    @Override
    public void orderSupply(Order order) {


    }
}
