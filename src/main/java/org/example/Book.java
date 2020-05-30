package org.example;

public class Book extends Item {
    public Book(String name, int price) {
        super(name, price, ItemTypes.book);
    }
}
