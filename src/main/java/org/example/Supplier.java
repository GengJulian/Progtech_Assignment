package org.example;

public abstract class  Supplier {
    Enum supplierType;

    public Enum getType(){
        return this.supplierType;
    }

    public void produce(Order order){

        packageProduct();
        sendProduct();
    }

    public abstract Item packageProduct(Item product);
}
