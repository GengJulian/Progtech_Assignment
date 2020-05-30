package org.example;

import java.util.ArrayList;
import java.util.List;

public class SmallWarehouse extends Warehouse{


    public SmallWarehouse(String name) {
        super(name,WarehouseTypes.small);
        super.capacity = 200;
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

    @Override
    public String toString() {
        return "Warehouse{" +
                "name=" + super.name + '\'' +
                ", type=" + type +'\'' +
                ", capacity="+capacity+
                '}';
    }
}
