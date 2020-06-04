package org.example;

import java.util.*;

public class Manager {
    Map<String,Warehouse> managedWarehouses = new HashMap<>();

    public void addWarehouse(Warehouse warehouse){
        managedWarehouses.put(warehouse.name,warehouse);
    }

    public void removeWarehouse(String whName){
        if(managedWarehouses.remove(whName) == null){
            System.out.println(String.format("%f is not among the managed warehouses!",whName));
            return;
        }
        System.out.println(String.format("%f has successfully removed from the managed warehouses!",whName));
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

    public Item orderItem(Order itemorder) throws InterruptedException {
        Iterator it = managedWarehouses.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry mapElement = (Map.Entry)it.next();
            Item item = ((Warehouse)mapElement.getValue()).getItem(itemorder);
            if(item != null){
                return item;
            }
        }
        System.out.println("Nincs raktáron a kívánt termék!\n Termék beszerzése folyamatban!");
        return null;
    }

    public void orderSupply(String warehouseName,Order order){
        managedWarehouses.get(warehouseName).orderSupply(order);
    }









}
