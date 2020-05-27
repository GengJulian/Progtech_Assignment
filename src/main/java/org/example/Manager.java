package org.example;

import java.util.ArrayList;
import java.util.List;

public class Manager {

    List<Warehouse> managedWarehouses = new ArrayList<Warehouse>();


    public void listWarehouses(){
        for(Warehouse warehouse : managedWarehouses){
            System.out.println(warehouse.toString());
        }
    }


}
