package org.example;

public class WarehouseFactory {

    private static WarehouseFactory instance;

    private WarehouseFactory(){}



    public static WarehouseFactory getInstance(){
        if(instance == null){
            instance = new WarehouseFactory();
        }
        return instance;
    }

    public Warehouse createWarehouse(String name,WarehouseTypes type){
        switch (type){
            case small:
                return new SmallWarehouse(name);
            case medium:
                return new MediumWarehouse(name);
            case large:
                return new LargeWarehouse(name);
            default:
                return null;
        }
    }
}
