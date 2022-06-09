package com.dronemanagementapi.data.response;

public class DroneBatteryResponse extends GeneralData {
   private String serialNumber;

   private Double batteryCapacity;

   public void setSerialNumber(String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setBatteryCapacity(Double batteryCapacity) {
      this.batteryCapacity = batteryCapacity;
   }

   public String getSerialNumber() {
      return serialNumber;
   }

   public String getBatteryLevel() {
      return batteryCapacity + "%";
   }
}
