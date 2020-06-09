package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    static Manager whmanager;

    @BeforeAll
    static void initClasses(){
        whmanager = new Manager();
        whmanager.addWarehouse(new LargeWarehouse("LargeWarehouse01"));
        whmanager.registerSupplier("LargeWarehouse01",new BookSupplier("BookSupplier01"));
        whmanager.orderSupply("LargeWarehouse01",new Order("book",ItemTypes.book,3));
    }
    @Test
    void numberOfWarehouses(){
        assertEquals(2,whmanager.numberOfWarehouses());
    }

    @Test
    void addWarehouse() {
        whmanager.addWarehouse(new LargeWarehouse("LargeWarehouse02"));
        assertEquals(2,whmanager.numberOfWarehouses());
    }

    @Test
    void removeWarehouse() {
        whmanager.addWarehouse(new LargeWarehouse("LargeWarehouse02"));
        whmanager.removeWarehouse("LargeWarehouse02");
        assertEquals(1,whmanager.numberOfWarehouses());
    }

    @Test
    void listWarehouses() {
        whmanager.listWarehouses();
    }

    @Test
    void listStockpile() {
        whmanager.listStockpile("LargeWarehouse01");
    }

    @Test
    void listSuppliers() {
        whmanager.listSuppliers("LargeWarehouse01");
    }

    @Test
    void orderItem() throws InterruptedException {
        List<Item> orderedItems = whmanager.orderItem(new Order("book",ItemTypes.book,3));
        assertEquals(3,orderedItems.size());
    }

    @Test
    void orderSupply() {
        whmanager.orderSupply("LargeWarehouse01",new Order("book2",ItemTypes.book,4));
        assertEquals(4,whmanager.numOfSpecificItemInWarehouse("LargeWarehouse01","book2"));
    }
}