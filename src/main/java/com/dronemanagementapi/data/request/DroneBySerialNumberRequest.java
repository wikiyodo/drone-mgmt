package com.dronemanagementapi.data.request;

import javax.validation.constraints.NotEmpty;

public class DroneBySerialNumberRequest {
   @NotEmpty(message = "Serial number cannot be empty")
   private String serialNumber;

   public void setSerialNumber(String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }
}
