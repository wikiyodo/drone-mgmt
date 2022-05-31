package com.dronemanagementapi.data.response;

import com.dronemanagementapi.model.Drone;
import java.util.List;

public class DroneMedicationsResponse {
   private String serialNumber;
   private List<Drone> model;

   public void setSerialNumber(String serialNumber) {
      this.serialNumber = serialNumber;
   }

}
