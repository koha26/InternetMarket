package com.gadgets.entity;

public class SmartWatch extends Gadget {
    private String model;
    private String color;
    private String operationSystem;
    private String displayType;
    private String displaySize;
    private String displayResolution;
    private String procFrequency;
    private int memorySize;
    private String waterResistance;
    private double batteryCapacity;
    private double timeBatteryWork;
    private String material;
    private String materialStrap;
    private String dimension;
    private double weight;
    private boolean isWiFiInt;
    private boolean isNFCInt;
    private boolean isGPSInt;
    private boolean isCameraAvailable;
    private boolean isVideoAvailable;
    private boolean isMicroAvailable;

    public SmartWatch() {
    }

    public SmartWatch(String model, String color, String operationSystem, String displayType, String displaySize,
                      String displayResolution, String procFrequency, int memorySize, String waterResistance,
                      double batteryCapacity, double timeBatteryWork, String material, String materialStrap,
                      String dimension, double weight, boolean isWiFiInt, boolean isNFCInt, boolean isGPSInt,
                      boolean isCameraAvailable, boolean isVideoAvailable, boolean isMicroAvailable) {
        this.model = model;
        this.color = color;
        this.operationSystem = operationSystem;
        this.displayType = displayType;
        this.displaySize = displaySize;
        this.displayResolution = displayResolution;
        this.procFrequency = procFrequency;
        this.memorySize = memorySize;
        this.waterResistance = waterResistance;
        this.batteryCapacity = batteryCapacity;
        this.timeBatteryWork = timeBatteryWork;
        this.material = material;
        this.materialStrap = materialStrap;
        this.dimension = dimension;
        this.weight = weight;
        this.isWiFiInt = isWiFiInt;
        this.isNFCInt = isNFCInt;
        this.isGPSInt = isGPSInt;
        this.isCameraAvailable = isCameraAvailable;
        this.isVideoAvailable = isVideoAvailable;
        this.isMicroAvailable = isMicroAvailable;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    public String getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(String displaySize) {
        this.displaySize = displaySize;
    }

    public String getDisplayResolution() {
        return displayResolution;
    }

    public void setDisplayResolution(String displayResolution) {
        this.displayResolution = displayResolution;
    }

    public String getProcFrequency() {
        return procFrequency;
    }

    public void setProcFrequency(String procFrequency) {
        this.procFrequency = procFrequency;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    public String getWaterResistance() {
        return waterResistance;
    }

    public void setWaterResistance(String waterResistance) {
        this.waterResistance = waterResistance;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public double getTimeBatteryWork() {
        return timeBatteryWork;
    }

    public void setTimeBatteryWork(double timeBatteryWork) {
        this.timeBatteryWork = timeBatteryWork;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMaterialStrap() {
        return materialStrap;
    }

    public void setMaterialStrap(String materialStrap) {
        this.materialStrap = materialStrap;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isWiFiInt() {
        return isWiFiInt;
    }

    public void setWiFiInt(boolean wiFiInt) {
        isWiFiInt = wiFiInt;
    }

    public boolean isNFCInt() {
        return isNFCInt;
    }

    public void setNFCInt(boolean NFCInt) {
        isNFCInt = NFCInt;
    }

    public boolean isGPSInt() {
        return isGPSInt;
    }

    public void setGPSInt(boolean GPSInt) {
        isGPSInt = GPSInt;
    }

    public boolean isCameraAvailable() {
        return isCameraAvailable;
    }

    public void setCameraAvailable(boolean cameraAvailable) {
        isCameraAvailable = cameraAvailable;
    }

    public boolean isVideoAvailable() {
        return isVideoAvailable;
    }

    public void setVideoAvailable(boolean videoAvailable) {
        isVideoAvailable = videoAvailable;
    }

    public boolean isMicroAvailable() {
        return isMicroAvailable;
    }

    public void setMicroAvailable(boolean microAvailable) {
        isMicroAvailable = microAvailable;
    }
}
