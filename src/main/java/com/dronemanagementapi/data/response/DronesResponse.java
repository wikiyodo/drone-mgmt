package com.dronemanagementapi.data.response;

import com.dronemanagementapi.model.Drone;
import com.dronemanagementapi.model.Medication;

import java.util.List;

public class DronesResponse extends GeneralData {
   private List<Drone> drones;

   public void setDrone(List<Drone> drones) {
      this.drones = drones;
   }

   public List<Drone> getDrones() {
      return drones;
   }
}
