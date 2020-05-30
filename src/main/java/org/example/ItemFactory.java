package org.example;

public class ItemFactory {
    private static ItemFactory instance;

    public ItemFactory getInstance(){
        if(instance == null){
            instance = new ItemFactory();
        }
        return instance;
    }

    public Item createItem(String name,ItemTypes type,int price){
        switch (type){
            case food:
                return new Food(name,price);
            case book:
                return new Book(name,price);
            case electronic_device:
                return new ElectronicDevice(name,price);
            default:
                return null;
        }
    }
}
