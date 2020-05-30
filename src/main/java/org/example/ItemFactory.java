package org.example;

public class ItemFactory {
    private static ItemFactory instance;

    public ItemFactory getInstance(){
        if(instance == null){
            instance = new ItemFactory();
        }
        return instance;
    }

    public Item createItem(String name,ItemTypes type){
        switch (type){
            case food:
                return new Food(name,5);
            case book:
                return new Book(name,10);
            case electronic_device:
                return new ElectronicDevice(name,20);
            default:
                return null;
        }
    }
}
