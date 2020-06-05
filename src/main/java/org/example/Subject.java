package org.example;


import java.util.List;

public interface Subject {
    public void registerSupplier(Supplier supplier);
    public void unregisterSupplier(String supplierName,ItemTypes supplierType);
    public void notifySuppliers(Order itemorder);
    public void receiveSupply(List<Item> supply);
}
