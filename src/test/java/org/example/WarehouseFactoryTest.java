package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseFactoryTest {


    @Test
    void getInstance() {
        WarehouseFactory factory = WarehouseFactory.getInstance();
        WarehouseFactory factory2 = WarehouseFactory.getInstance();
        assertEquals(factory,factory2);
    }

    @Test
    void createWarehouse() {
        WarehouseFactory factory = WarehouseFactory.getInstance();
        Warehouse smallWarehouse = factory.createWarehouse("small",WarehouseTypes.small);
        Warehouse mediumWarehouse = factory.createWarehouse("medium",WarehouseTypes.medium);
        Warehouse largeWarehouse = factory.createWarehouse("large",WarehouseTypes.large);
        assertNotEquals(null,smallWarehouse);
        assertNotEquals(null,mediumWarehouse);
        assertNotEquals(null,largeWarehouse);
    }
}