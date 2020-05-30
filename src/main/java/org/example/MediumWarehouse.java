package org.example;

import java.util.ArrayList;
import java.util.List;

public class MediumWarehouse extends Warehouse {

    public MediumWarehouse(String name) {
        super(name,WarehouseTypes.medium);
        super.capacity = 500;
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

    @Override
    public String toString() {
        return "Warehouse{" +
                "name=" + name + '\'' +
                ", type=" + type +'\'' +
                ", capacity="+capacity+
                '}';
    }
}
