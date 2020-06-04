package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemFactoryTest {
    ItemFactory factory = ItemFactory.getInstance();;
    @Test
    void getInstance() {
        assertEquals(factory,ItemFactory.getInstance());
    }

    @Test
    void createBook() {
        Item item = factory.createItem("book",ItemTypes.book);
        assertEquals(item.name,"book");
        assertEquals(item.type,ItemTypes.book);
    }

    @Test
    void createFood() {
        Item item = factory.createItem("étel",ItemTypes.food);
        assertEquals(item.name,"étel");
        assertEquals(item.type,ItemTypes.food);
    }

    @Test
    void createElectronicDevice() {
        Item item = factory.createItem("battery",ItemTypes.electronic_device);
        assertEquals(item.name,"battery");
        assertEquals(item.type,ItemTypes.electronic_device);
    }
}