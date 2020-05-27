package org.example;

public class LargeWarehouse extends Warehouse{


    public LargeWarehouse(String name) {
        super(name);
    }

    @Override
    public Item getItem(String itemName) throws InterruptedException {
        for (Item item : stockpile){
            if (item.name == itemName){
                stockpile.remove(item);
                return item;
            }
            Thread.sleep(40000);
        }
        return null;
    }

    @Override
    public void orderSupply(Order order) {

    }
}
