package org.example;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargeWarehouseTest {
    LargeWarehouse warehouse = new LargeWarehouse("LargeWarehouse01");


    @BeforeEach
    void initClasses(){
        warehouse.registerSupplier(new FoodSupplier());
        warehouse.registerSupplier(new BookSupplier());
        warehouse.registerSupplier(new ElectronicDeviceSupplier());
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
    void testToString() {
    }

    @Test
    void getItem() throws InterruptedException {
        assertEquals(new Book("book1",10),
                warehouse.getItem(new Order("book1",ItemTypes.book,1)));
    }

    @Test
    void orderSupply() {
    }

    @Test
    void testToString1() {
    }

    @Test
    void registerSupplier() {
    }

    @Test
    void unregisterSupplier() {
    }

    @Test
    void notifySuppliers() {
    }

    @Test
    void receiveSupply() {
    }
}