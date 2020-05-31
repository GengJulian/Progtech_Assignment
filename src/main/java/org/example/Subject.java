package org.example;


import java.util.List;

public interface Subject {
    public void registerSupplier(Supplier supplier);
    public void unregisterSupplier(Supplier supplier);
    public void notifySuppliers(Order itemorder);
    public void receiveSupply(List<Item> supply);
}
