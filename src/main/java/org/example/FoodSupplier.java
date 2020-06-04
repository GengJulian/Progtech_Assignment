package org.example;

public class FoodSupplier extends Supplier {
    @Override
    protected void packageProduct(Item product) {
        System.out.println("Az étel be lett csomagolva.");
    }

    @Override
    public void update(Order itemorder,Warehouse notifier) {
        notifier.receiveSupply(super.sendProduct(itemorder));
    }

    @Override
    public void setSubject(Subject sub) {


    }
}
