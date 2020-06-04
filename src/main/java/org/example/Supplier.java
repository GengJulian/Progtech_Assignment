package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class  Supplier implements Observer{

    ItemTypes supplierType;
    ItemFactory itemFactory = new ItemFactory();

    public ItemTypes getType(){
        return this.supplierType;
    }

    public List<Item> sendProduct(Order order){
        return produce(order);
    }

    private List<Item> produce(Order order){
        List<Item>supply = new ArrayList<>();
        for (int i= 0;i<order.quantity;i++){
            Item product = itemFactory.createItem(order.itemName,order.itemType);
            packageProduct(product);
            supply.add(product);
        }
        return supply;
    }

    protected abstract void packageProduct(Item product);

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierType=" + supplierType +
                '}';
    }
}
