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
}
