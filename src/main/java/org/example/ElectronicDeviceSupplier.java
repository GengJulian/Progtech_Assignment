package org.example;

public class ElectronicDeviceSupplier extends Supplier{

    public ElectronicDeviceSupplier(String supplierName){

        this.supplierType = ItemTypes.electronic_device;
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
