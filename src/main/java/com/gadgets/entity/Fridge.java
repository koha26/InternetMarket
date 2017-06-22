package com.gadgets.entity;

public class Fridge extends Appliance{
    private String type;
    private double height;
    private double width;
    private double depth;
    private double volume;
    private boolean isFrizerAvailable;
    private double volumeFrizer;
    private String instalationMethod;
    private String color;

    public Fridge() {
    }

    public Fridge(String type, double height, double width, double depth, double volume, boolean isFrizerAvailable,
                  double volumeFrizer, String instalationMethod, String color) {
        this.type = type;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.volume = volume;
        this.isFrizerAvailable = isFrizerAvailable;
        this.volumeFrizer = volumeFrizer;
        this.instalationMethod = instalationMethod;
        this.color = color;
    }

    public Fridge(String category, String type, double height, double width, double depth, double volume,
                  boolean isFrizerAvailable, double volumeFrizer, String instalationMethod, String color) {
        super(category);
        this.type = type;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.volume = volume;
        this.isFrizerAvailable = isFrizerAvailable;
        this.volumeFrizer = volumeFrizer;
        this.instalationMethod = instalationMethod;
        this.color = color;
    }

    public Fridge(int id, String name, String price, String producer, String category, String type, double height,
                  double width, double depth, double volume, boolean isFrizerAvailable, double volumeFrizer,
                  String instalationMethod, String color) {
        super(id, name, price, producer, category);
        this.type = type;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.volume = volume;
        this.isFrizerAvailable = isFrizerAvailable;
        this.volumeFrizer = volumeFrizer;
        this.instalationMethod = instalationMethod;
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public boolean isFrizerAvailable() {
        return isFrizerAvailable;
    }

    public void setFrizerAvailable(boolean frizerAvailable) {
        isFrizerAvailable = frizerAvailable;
    }

    public double getVolumeFrizer() {
        return volumeFrizer;
    }

    public void setVolumeFrizer(double volumeFrizer) {
        this.volumeFrizer = volumeFrizer;
    }

    public String getInstalationMethod() {
        return instalationMethod;
    }

    public void setInstalationMethod(String instalationMethod) {
        this.instalationMethod = instalationMethod;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
