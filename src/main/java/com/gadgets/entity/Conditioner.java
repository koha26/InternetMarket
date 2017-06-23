package com.gadgets.entity;

import java.util.Arrays;

public class Conditioner extends Appliance {
    private String type;
    private double conditionSquare;
    private String[] modes;
    private String instalationTypeInnerUnit;
    private String typeInventor;
    private String color;

    public Conditioner() {
    }

    public Conditioner(String type, double conditionSquare, String[] modes, String instalationTypeInnerUnit,
                       String typeInventor, String color) {
        this.type = type;
        this.conditionSquare = conditionSquare;
        this.modes = modes;
        this.instalationTypeInnerUnit = instalationTypeInnerUnit;
        this.typeInventor = typeInventor;
        this.color = color;
    }

    public Conditioner(String category, String type, double conditionSquare, String[] modes,
                       String instalationTypeInnerUnit, String typeInventor, String color) {
        super(category);
        this.type = type;
        this.conditionSquare = conditionSquare;
        this.modes = modes;
        this.instalationTypeInnerUnit = instalationTypeInnerUnit;
        this.typeInventor = typeInventor;
        this.color = color;
    }

    public Conditioner(int id, String name, double price, String producer, String category, String type,
                       double conditionSquare, String[] modes, String instalationTypeInnerUnit, String typeInventor,
                       String color) {
        super(id, name, price, producer, category);
        this.type = type;
        this.conditionSquare = conditionSquare;
        this.modes = modes;
        this.instalationTypeInnerUnit = instalationTypeInnerUnit;
        this.typeInventor = typeInventor;
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getConditionSquare() {
        return conditionSquare;
    }

    public void setConditionSquare(double conditionSquare) {
        this.conditionSquare = conditionSquare;
    }

    public String[] getModes() {
        return modes;
    }

    public void setModes(String[] modes) {
        this.modes = modes;
    }

    public String getInstalationTypeInnerUnit() {
        return instalationTypeInnerUnit;
    }

    public void setInstalationTypeInnerUnit(String instalationTypeInnerUnit) {
        this.instalationTypeInnerUnit = instalationTypeInnerUnit;
    }

    public String getTypeInventor() {
        return typeInventor;
    }

    public void setTypeInventor(String typeInventor) {
        this.typeInventor = typeInventor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Conditioner that = (Conditioner) o;

        if (Double.compare(that.conditionSquare, conditionSquare) != 0) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(modes, that.modes)) return false;
        if (instalationTypeInnerUnit != null ? !instalationTypeInnerUnit.equals(that.instalationTypeInnerUnit) : that.instalationTypeInnerUnit != null)
            return false;
        if (typeInventor != null ? !typeInventor.equals(that.typeInventor) : that.typeInventor != null) return false;
        return color != null ? color.equals(that.color) : that.color == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        temp = Double.doubleToLongBits(conditionSquare);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + Arrays.hashCode(modes);
        result = 31 * result + (instalationTypeInnerUnit != null ? instalationTypeInnerUnit.hashCode() : 0);
        result = 31 * result + (typeInventor != null ? typeInventor.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }
}
