package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookSupplierTest {
    Supplier bookSupplier = new BookSupplier("bookSupplier01");
    @Test
    void produce(){
            List<Item> items = bookSupplier.produce(new Order("book",ItemTypes.book,2));
            assertEquals(2,items.size());
    }

    @Test
    void getType() {
        assertEquals(ItemTypes.book,bookSupplier.getType());
    }

    @Test
    void sendProduct() {
        List<Item> items = bookSupplier.produce(new Order("book",ItemTypes.book,2));
        assertEquals(2,items.size());

    }

    @Test
    void packageProduct() {
        bookSupplier.packageProduct(new Book("book",10));
    }

    @Test
    void update() {
        Warehouse warehouse = new LargeWarehouse("Warehouse01");
        warehouse.registerSupplier(bookSupplier);
        bookSupplier.update(new Order("book",ItemTypes.book,2),warehouse);
        assertEquals(2,warehouse.stockpile.size());
    }
}