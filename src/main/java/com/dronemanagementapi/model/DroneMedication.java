package com.dronemanagementapi.model;

import javax.persistence.Column;

public class DroneMedication {
   @Column(name = "drone_id", columnDefinition = "INT NOT NULL")
   private int droneId;

   @Column(name = "medication_id", columnDefinition = "INT NOT NULL")
   private int medicationId;

   public DroneMedication() {
   }

   public DroneMedication(int droneId, int medicationId) {
      this.droneId = droneId;
      this.medicationId = medicationId;
   }

}
