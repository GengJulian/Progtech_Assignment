package org.example;

public class BookSupplier extends Supplier{

    public BookSupplier(String supplierName){
        this.supplierType = ItemTypes.book;
        this.supplierName = supplierName;
    }

    @Override
    protected void packageProduct(Item product) {
        System.out.println(String.format("%s be lett csomagolva!",product.name));
    }

    @Override
    public void update(Order itemorder,Warehouse notifier) {
        notifier.receiveSupply(super.sendProduct(itemorder));
    }

}
