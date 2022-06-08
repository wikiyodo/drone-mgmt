package com.dronemanagementapi.data.response;

import com.dronemanagementapi.model.Drone;
import com.dronemanagementapi.model.Medication;

import java.util.List;

public class DroneMedicationsResponse extends GeneralData {
   private List<Medication> medications;
   private Drone drone;

   public void setDrone(Drone drone) {
      this.drone = drone;
   }

   public Drone getDrone() {
      return drone;
   }

   public void setMedications(List<Medication> medications) {
      this.medications = medications;
   }

   public List<Medication> getMedications() {
      return medications;
   }
}
