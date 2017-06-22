package com.gadgets.entity;

public abstract class SellableProduct {
    private int id;
    private String name;
    private String price;
    private String producer;

    public SellableProduct() {
    }

    public SellableProduct(int id, String name, String price, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.producer = producer;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("SellableProduct{")
                .append("price='")
                .append(price)
                .append('\'')
                .append(", name='")
                .append(name)
                .append('\'')
                .append(", producer='")
                .append(producer)
                .append('\'')
                .append("}").toString();
    }
}
