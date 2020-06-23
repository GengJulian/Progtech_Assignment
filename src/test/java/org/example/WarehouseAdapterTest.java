package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseAdapterTest {
    static WarehouseAdapter adapter;

    @BeforeAll
    static void initClasses(){
        OutsiderWarehouse warehouse = new OutsiderWarehouse("Owarehouse01",WarehouseTypes.small);
        warehouse.cargo.add(new Book("book1",10));
        warehouse.suppliers.add(new BookSupplier("bookSupplier01"));

        adapter = new WarehouseAdapter(warehouse);

    }

    @Test
    void numberOfSpecificItem() {
        int expected = 1;
        int actual = adapter.numberOfSpecificItem("book1");
        assertEquals(expected,actual);
    }

    @Test
    void listStockpile() {
        adapter.listStockpile();
    }

    @Test
    void listSuppliers() {
        adapter.listSuppliers();
    }

    @Test
    void getItem() {
        List<Item> items = adapter.getItem(new Order("book1",ItemTypes.book,1));
        assertEquals(1,items.size());
    }

    @Test
    void orderSupply() {
        adapter.orderSupply(new Order("book2",ItemTypes.book,1));
    }

    @Test
    void registerSupplier() {
        adapter.registerSupplier(new BookSupplier("bookSupplier02"));
        assertEquals(2,adapter.suppliers.size());
    }

    @Test
    void unregisterSupplier() {
        adapter.registerSupplier(new BookSupplier("bookSupplier02"));
        System.out.println(adapter.suppliers.size());
        adapter.unregisterSupplier("bookSupplier02",ItemTypes.book);
    }

    @Test
    void receiveSupply() {
        List<Item> supply = new ArrayList<Item>();
        supply.add(new Book("book03",100));
        int numberOfItems = adapter.stockpile.size();
        adapter.receiveSupply(supply);

        assertEquals(numberOfItems+1,numberOfItems+supply.size());


    }
}