package org.example;

public class WarehouseAdapter extends Warehouse{
    OutsiderWarehouse adaptee;
    public WarehouseAdapter(OutsiderWarehouse adaptee) {
        super(adaptee.name,WarehouseTypes.outsider);
        super.stockpile = adaptee.cargo();
        super.suppliers = adaptee.suppliers();
        this.adaptee = adaptee;
    }

    @Override
    public Item getItem(String itemName) throws InterruptedException {
        Item outsiderItem = adaptee.getCargoItem();
        outsiderItem.price += 10;
        return outsiderItem;
    }

    @Override
    public void orderSupply(Order order) {
        adaptee.RefulStock();
    }
}
