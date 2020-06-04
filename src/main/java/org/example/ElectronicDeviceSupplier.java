package org.example;

public class ElectronicDeviceSupplier extends Supplier{
    @Override
    protected void packageProduct(Item product) {
        System.out.println("Az elektronikai eszköz be lett somagolva!");
    }

    @Override
    public void update(Order itemorder,Warehouse notifier) {
        notifier.receiveSupply(super.sendProduct(itemorder));
    }

    @Override
    public void setSubject(Subject sub) {

    }
}
