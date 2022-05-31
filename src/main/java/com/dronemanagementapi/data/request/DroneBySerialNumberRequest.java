package com.dronemanagementapi.data.request;

public class DroneBySerialNumberRequest {
   private String serialNumber;

   public void setSerialNumber(String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }
}
