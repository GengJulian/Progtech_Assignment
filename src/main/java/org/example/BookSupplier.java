package org.example;

public class BookSupplier extends Supplier{

    public BookSupplier(){
        this.supplierType = ItemTypes.book;
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
