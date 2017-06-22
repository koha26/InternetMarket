package com.gadgets.entity;

public abstract class Appliance extends SellableProduct{
    private String category;

    public Appliance() {
    }

    public Appliance(String category) {
        this.category = category;
    }

    public Appliance(int id, String name, String price, String producer, String category) {
        super(id, name, price, producer);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
