package org.example;

public abstract class Item {
    String name;
    int price;
    Enum type;

    public Item(String name,int price,Enum type){
        this.name = name;
        this.price = price;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", type=" + type +
                '}';
    }
}
