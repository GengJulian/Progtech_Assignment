package org.example;

public class FoodSupplier extends Supplier {

    public FoodSupplier(){
        this.supplierType = ItemTypes.electronic_device;
    }

    @Override
    protected void packageProduct(Item product) {
        System.out.println(String.format("%s be lett csomagolva!",product.name));;
    }

    @Override
    public void update(Order itemorder,Warehouse notifier) {

        notifier.receiveSupply(super.sendProduct(itemorder));
    }

}
