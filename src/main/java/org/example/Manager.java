package org.example;

import java.util.*;

public class Manager {
    private Map<String,Warehouse> managedWarehouses = new HashMap<>();

    public int numberOfWarehouses(){
        return managedWarehouses.size();
    }

    public void addWarehouse(Warehouse warehouse){
        managedWarehouses.put(warehouse.name,warehouse);
    }

    public void removeWarehouse(String whName){
        if(managedWarehouses.remove(whName) == null){
            System.out.println(String.format(whName + " is not among the managed warehouses!"));
            return;
        }
        System.out.println(String.format(whName + "has successfully removed from the managed warehouses!"));
    }

    public void registerSupplier(String warehouseName,Supplier newSupplier){
        if(warehouseName == null || newSupplier == null){
            throw new IllegalArgumentException();
        }
        managedWarehouses.get(warehouseName).registerSupplier(newSupplier);
    }

    public void listWarehouses(){
        System.out.println("Managed warehouses:");
        Iterator it = managedWarehouses.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry mapElement = (Map.Entry)it.next();
            System.out.println(mapElement.getKey());
        }
    }

    public void listStockpile(String warehouseName){
        System.out.println("Managed warehouses:");
        managedWarehouses.get(warehouseName).listStockpile();
    }

    public void listSuppliers(String warehouseName){
        managedWarehouses.get(warehouseName).listSuppliers();
    }

    public List<Item> orderItem(Order itemorder) throws InterruptedException {
        List<Item> orderedItems = new ArrayList<>();
        Iterator it = managedWarehouses.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry mapElement = (Map.Entry)it.next();
            Warehouse managedWarehouse = (Warehouse)mapElement.getValue();
            orderedItems.addAll(managedWarehouse.getItem(itemorder));
            //Thread.sleep(40000);
            if(orderedItems.size() == itemorder.quantity){
                return orderedItems;
            }
            itemorder.quantity -= orderedItems.size();
        }
        System.out.println("Nincs raktáron a kívánt termék!\n Termék beszerzése folyamatban!");
        return null;
    }

    public void orderSupply(String warehouseName,Order order){
        managedWarehouses.get(warehouseName).orderSupply(order);
    }

    public int numOfSpecificItemInWarehouse(String warehouseName,String itemName){
        return managedWarehouses.get(warehouseName).numberOfSpecificItem(itemName);
    }









}
