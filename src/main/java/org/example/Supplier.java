package org.example;

public abstract class  Supplier {
    ItemTypes supplierType;
    ItemFactory itemFactory = new ItemFactory();

    public ItemTypes getType(){
        return this.supplierType;
    }

    public Item sendProduct(Order order){
        return produce(order);
    }

    private Item produce(Order order){
        Item product = itemFactory.createItem(order.itemName,order.itemType);
        packageProduct(product);
        return product;
    }

    protected abstract void packageProduct(Item product);

}
