package org.example;

public class Order {
    String itemName;
    Enum itemType;
    int quantity;

    public Order(String itemName,Enum itemType,int quantity){
        this.itemName = itemName;
        this.itemType = itemType;
        this.quantity = quantity;
    }


}
