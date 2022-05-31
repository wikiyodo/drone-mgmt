package com.dronemanagementapi.data.response;

public class DroneResponse {
   private String message;
   private String serialNumber;
   private String model;
   private Double weightLimit;
   private Double batteryCapacity;
   private String state;

   public void setMessage(String message) {
      this.message = message;
   }

   public void setSerialNumber(String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setModel(String model) {
      this.model = model;
   }

   public void setWeightLimit(Double weightLimit) {
      this.weightLimit = weightLimit;
   }

   public void setBatteryCapacity(Double batteryCapacity) {
      this.batteryCapacity = batteryCapacity;
   }

   public void setState(String state) {
      this.state = state;
   }

   public String getMessage() {
      return message;
   }

   public String getSerialNumber() {
      return serialNumber;
   }

   public String getModel() {
      return model;
   }

   public Double getWeightLimit() {
      return weightLimit;
   }

   public Double getBatteryCapacity() {
      return batteryCapacity;
   }

   public String getState() {
      return state;
   }

}
