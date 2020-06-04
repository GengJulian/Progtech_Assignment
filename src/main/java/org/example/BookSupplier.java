package org.example;

public class BookSupplier extends Supplier{
    @Override
    protected void packageProduct(Item product) {
        System.out.println("A könyv be lett csomagolva!");
    }

    @Override
    public void update(Order itemorder,Warehouse notifier) {
        notifier.receiveSupply(super.sendProduct(itemorder));
    }

    @Override
    public void setSubject(Subject sub) {

    }
}
