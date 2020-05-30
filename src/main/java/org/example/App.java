package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        WarehouseFactory whFactory = new WarehouseFactory();
        Manager warehouseManager = new Manager();
        Warehouse warehouse;
        for (int i = 0;i<5;i++){
            warehouse = whFactory.createWarehouse("small_Warehouse"+i,WarehouseTypes.small);
            warehouseManager.addWarehouse(warehouse);
            /*
            warehouse = whFactory.createWarehouse("medium_Warehouse"+i,WarehouseTypes.medium);
            warehouseManager.addWarehouse(warehouse);
            warehouse = whFactory.createWarehouse("large_Warehouse"+i,WarehouseTypes.large);
            warehouseManager.addWarehouse(warehouse);
             */
        }
        warehouseManager.listWarehouses();
    }
}
