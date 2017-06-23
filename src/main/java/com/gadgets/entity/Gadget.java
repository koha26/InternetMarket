package com.gadgets.entity;

/**
 * Abstract class which presents handle devices and
 * has own category in this subject.
 */
public abstract class Gadget extends SellableProduct {
    private String category;

    public Gadget() {
    }

    public Gadget(String category) {
        this.category = category;
    }

    public Gadget(int id, String name, double price, String producer, String category) {
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

        Gadget gadget = (Gadget) o;

        return category != null ? category.equals(gadget.category) : gadget.category == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }
}
