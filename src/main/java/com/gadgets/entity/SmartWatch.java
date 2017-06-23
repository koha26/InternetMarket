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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        SmartWatch that = (SmartWatch) o;

        if (memorySize != that.memorySize) return false;
        if (Double.compare(that.batteryCapacity, batteryCapacity) != 0) return false;
        if (Double.compare(that.timeBatteryWork, timeBatteryWork) != 0) return false;
        if (Double.compare(that.weight, weight) != 0) return false;
        if (isWiFiInt != that.isWiFiInt) return false;
        if (isNFCInt != that.isNFCInt) return false;
        if (isGPSInt != that.isGPSInt) return false;
        if (isCameraAvailable != that.isCameraAvailable) return false;
        if (isVideoAvailable != that.isVideoAvailable) return false;
        if (isMicroAvailable != that.isMicroAvailable) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;
        if (operationSystem != null ? !operationSystem.equals(that.operationSystem) : that.operationSystem != null)
            return false;
        if (displayType != null ? !displayType.equals(that.displayType) : that.displayType != null) return false;
        if (displaySize != null ? !displaySize.equals(that.displaySize) : that.displaySize != null) return false;
        if (displayResolution != null ? !displayResolution.equals(that.displayResolution) : that.displayResolution != null)
            return false;
        if (procFrequency != null ? !procFrequency.equals(that.procFrequency) : that.procFrequency != null)
            return false;
        if (waterResistance != null ? !waterResistance.equals(that.waterResistance) : that.waterResistance != null)
            return false;
        if (material != null ? !material.equals(that.material) : that.material != null) return false;
        if (materialStrap != null ? !materialStrap.equals(that.materialStrap) : that.materialStrap != null)
            return false;
        return dimension != null ? dimension.equals(that.dimension) : that.dimension == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (operationSystem != null ? operationSystem.hashCode() : 0);
        result = 31 * result + (displayType != null ? displayType.hashCode() : 0);
        result = 31 * result + (displaySize != null ? displaySize.hashCode() : 0);
        result = 31 * result + (displayResolution != null ? displayResolution.hashCode() : 0);
        result = 31 * result + (procFrequency != null ? procFrequency.hashCode() : 0);
        result = 31 * result + memorySize;
        result = 31 * result + (waterResistance != null ? waterResistance.hashCode() : 0);
        temp = Double.doubleToLongBits(batteryCapacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(timeBatteryWork);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (material != null ? material.hashCode() : 0);
        result = 31 * result + (materialStrap != null ? materialStrap.hashCode() : 0);
        result = 31 * result + (dimension != null ? dimension.hashCode() : 0);
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (isWiFiInt ? 1 : 0);
        result = 31 * result + (isNFCInt ? 1 : 0);
        result = 31 * result + (isGPSInt ? 1 : 0);
        result = 31 * result + (isCameraAvailable ? 1 : 0);
        result = 31 * result + (isVideoAvailable ? 1 : 0);
        result = 31 * result + (isMicroAvailable ? 1 : 0);
        return result;
    }
}
