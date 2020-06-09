package org.example;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LargeWarehouseTest {
    LargeWarehouse warehouse = new LargeWarehouse("LargeWarehouse01");


    @BeforeEach
    void initClasses(){
        warehouse.registerSupplier(new FoodSupplier("FoodSupplier01"));
        warehouse.registerSupplier(new BookSupplier("BookSupplier01"));
        warehouse.registerSupplier(new ElectronicDeviceSupplier("ElectronicSupplier01"));
        warehouse.orderSupply(new Order("book1",ItemTypes.book,1));
        warehouse.orderSupply(new Order("kenyér",ItemTypes.food,1));
        warehouse.orderSupply(new Order("pc",ItemTypes.electronic_device,1));
    }

    @Test
    void listStockpile() {
        warehouse.listStockpile();
    }

    @Test
    void listSuppliers() {
        warehouse.listSuppliers();
    }


    @Test
    void getItem() throws InterruptedException {
        List<Item> items = warehouse.getItem(new Order("book1",ItemTypes.book,1));
        assertNotEquals(null,items.get(0));
        assertEquals("book1",items.get(0).name);
        assertEquals(ItemTypes.book,items.get(0).type);
    }

    @Test
    void orderSupply() {
        warehouse.orderSupply(new Order("book2",ItemTypes.book,5));
        assertEquals(8,warehouse.stockpile.size());
    }

    @Test
    void registerSupplier() {
        warehouse.registerSupplier(new BookSupplier("BookSupplier02"));
        assertEquals(4,warehouse.suppliers.size());
    }

    @Test
    void unregisterSupplier() {
        warehouse.unregisterSupplier("BookSupplier01",ItemTypes.book);
        assertEquals(2,warehouse.suppliers.size());
    }

    @Test
    void notifySuppliers() {
        warehouse.notifySuppliers(new Order("book2",ItemTypes.book,5));
        assertEquals(8,warehouse.stockpile.size());
    }
}