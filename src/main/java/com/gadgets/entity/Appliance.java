package com.gadgets.entity;

/**
 * Abstract class which presents household devices and
 * has own category in this subject.
 */
public abstract class Appliance extends SellableProduct{
    private String category;

    public Appliance() {
    }

    public Appliance(String category) {
        this.category = category;
    }

    public Appliance(int id, String name, double price, String producer, String category) {
        super(id, name, price, producer);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Appliance appliance = (Appliance) o;

        return category != null ? category.equals(appliance.category) : appliance.category == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }
}
