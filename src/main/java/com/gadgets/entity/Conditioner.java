package com.gadgets.entity;

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

    public Conditioner(int id, String name, String price, String producer, String category, String type,
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
}
