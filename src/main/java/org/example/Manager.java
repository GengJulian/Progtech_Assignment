package org.example;

import java.util.ArrayList;
import java.util.List;

public class Manager {

    List<Warehouse> managedWarehouses = new ArrayList<Warehouse>();

    public void addWarehouse(Warehouse warehouse){
        managedWarehouses.add(warehouse);
    }

    public boolean removeWarehouse(String whName){
        for (Warehouse warehouse : managedWarehouses){
            if(warehouse.name == whName){
                managedWarehouses.remove(warehouse);
                System.out.println(String.format("%f has successfully removed!",whName));
                return true;
            }
        }
        return false;
    }

    public void listWarehouses(){
        for(Warehouse warehouse : managedWarehouses){
            System.out.println(warehouse.toString());
        }
    }





}
