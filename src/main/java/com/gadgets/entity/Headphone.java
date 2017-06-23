package com.gadgets.entity;

public class Headphone extends Gadget {
    private String type;
    private String connectionType;
    private String color;
    private String mission;
    private String connectionInterf;
    private boolean isMicroAvailable;
    private int minFrequency;
    private int maxFrequency;
    private int resist;
    private int sensitivity;
    private double weight;
    private String additionalInfo;

    public Headphone() {
    }

    public Headphone(String type, String connectionType, String color, String mission, String connectionInterf,
                     boolean isMicroAvailable, int minFrequency, int maxFrequency, int resist, int sensitivity,
                     double weight, String additionalInfo) {
        this.type = type;
        this.connectionType = connectionType;
        this.color = color;
        this.mission = mission;
        this.connectionInterf = connectionInterf;
        this.isMicroAvailable = isMicroAvailable;
        this.minFrequency = minFrequency;
        this.maxFrequency = maxFrequency;
        this.resist = resist;
        this.sensitivity = sensitivity;
        this.weight = weight;
        this.additionalInfo = additionalInfo;
    }

    public Headphone(String category, String type, String connectionType, String color, String mission,
                     String connectionInterf, boolean isMicroAvailable, int minFrequency, int maxFrequency,
                     int resist, int sensitivity, double weight, String additionalInfo) {
        super(category);
        this.type = type;
        this.connectionType = connectionType;
        this.color = color;
        this.mission = mission;
        this.connectionInterf = connectionInterf;
        this.isMicroAvailable = isMicroAvailable;
        this.minFrequency = minFrequency;
        this.maxFrequency = maxFrequency;
        this.resist = resist;
        this.sensitivity = sensitivity;
        this.weight = weight;
        this.additionalInfo = additionalInfo;
    }

    public Headphone(int id, String name, double price, String producer, String category, String type,
                     String connectionType, String color, String mission, String connectionInterf,
                     boolean isMicroAvailable, int minFrequency, int maxFrequency, int resist, int sensitivity,
                     double weight, String additionalInfo) {
        super(id, name, price, producer, category);
        this.type = type;
        this.connectionType = connectionType;
        this.color = color;
        this.mission = mission;
        this.connectionInterf = connectionInterf;
        this.isMicroAvailable = isMicroAvailable;
        this.minFrequency = minFrequency;
        this.maxFrequency = maxFrequency;
        this.resist = resist;
        this.sensitivity = sensitivity;
        this.weight = weight;
        this.additionalInfo = additionalInfo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getConnectionInterf() {
        return connectionInterf;
    }

    public void setConnectionInterf(String connectionInterf) {
        this.connectionInterf = connectionInterf;
    }

    public boolean isMicroAvailable() {
        return isMicroAvailable;
    }

    public void setMicroAvailable(boolean microAvailable) {
        isMicroAvailable = microAvailable;
    }

    public int getMinFrequency() {
        return minFrequency;
    }

    public void setMinFrequency(int minFrequency) {
        this.minFrequency = minFrequency;
    }

    public int getMaxFrequency() {
        return maxFrequency;
    }

    public void setMaxFrequency(int maxFrequency) {
        this.maxFrequency = maxFrequency;
    }

    public int getResist() {
        return resist;
    }

    public void setResist(int resist) {
        this.resist = resist;
    }

    public int getSensitivity() {
        return sensitivity;
    }

    public void setSensitivity(int sensitivity) {
        this.sensitivity = sensitivity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Headphone headphone = (Headphone) o;

        if (isMicroAvailable != headphone.isMicroAvailable) return false;
        if (minFrequency != headphone.minFrequency) return false;
        if (maxFrequency != headphone.maxFrequency) return false;
        if (resist != headphone.resist) return false;
        if (sensitivity != headphone.sensitivity) return false;
        if (Double.compare(headphone.weight, weight) != 0) return false;
        if (type != null ? !type.equals(headphone.type) : headphone.type != null) return false;
        if (connectionType != null ? !connectionType.equals(headphone.connectionType) : headphone.connectionType != null)
            return false;
        if (color != null ? !color.equals(headphone.color) : headphone.color != null) return false;
        if (mission != null ? !mission.equals(headphone.mission) : headphone.mission != null) return false;
        if (connectionInterf != null ? !connectionInterf.equals(headphone.connectionInterf) : headphone.connectionInterf != null)
            return false;
        return additionalInfo != null ? additionalInfo.equals(headphone.additionalInfo) : headphone.additionalInfo == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (connectionType != null ? connectionType.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (mission != null ? mission.hashCode() : 0);
        result = 31 * result + (connectionInterf != null ? connectionInterf.hashCode() : 0);
        result = 31 * result + (isMicroAvailable ? 1 : 0);
        result = 31 * result + minFrequency;
        result = 31 * result + maxFrequency;
        result = 31 * result + resist;
        result = 31 * result + sensitivity;
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (additionalInfo != null ? additionalInfo.hashCode() : 0);
        return result;
    }
}
