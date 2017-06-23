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

    public Fridge(int id, String name, double price, String producer, String category, String type, double height,
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Fridge fridge = (Fridge) o;

        if (Double.compare(fridge.height, height) != 0) return false;
        if (Double.compare(fridge.width, width) != 0) return false;
        if (Double.compare(fridge.depth, depth) != 0) return false;
        if (Double.compare(fridge.volume, volume) != 0) return false;
        if (isFrizerAvailable != fridge.isFrizerAvailable) return false;
        if (Double.compare(fridge.volumeFrizer, volumeFrizer) != 0) return false;
        if (type != null ? !type.equals(fridge.type) : fridge.type != null) return false;
        if (instalationMethod != null ? !instalationMethod.equals(fridge.instalationMethod) : fridge.instalationMethod != null)
            return false;
        return color != null ? color.equals(fridge.color) : fridge.color == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(width);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(depth);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(volume);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (isFrizerAvailable ? 1 : 0);
        temp = Double.doubleToLongBits(volumeFrizer);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (instalationMethod != null ? instalationMethod.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }
}
