package com.gadgets.entity;

public abstract class SellableProduct {
    private int id;
    private String price;
    private String name;
    private String description;
    private String firmName;

    public SellableProduct() {
    }

    public SellableProduct(String price, String name, String description, String firmName) {
        this.price = price;
        this.name = name;
        this.description = description;
        this.firmName = firmName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SellableProduct item = (SellableProduct) o;

        if (!price.equals(item.price)) return false;
        if (!name.equals(item.name)) return false;
        if (!description.equals(item.description)) return false;
        return firmName.equals(item.firmName);
    }

    @Override
    public int hashCode() {
        int result = price.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + firmName.hashCode();
        return result;
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
                .append(", description='")
                .append(description)
                .append('\'')
                .append(", firmName='")
                .append(firmName)
                .append('\'')
                .append("}").toString();
    }
}
