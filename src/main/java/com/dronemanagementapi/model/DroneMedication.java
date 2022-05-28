package com.dronemanagementapi.model;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class DroneMedication {
   @Column(name = "drone_id", columnDefinition = "INT NOT NULL")
   private int droneId;

   @Column(name = "medication_id", columnDefinition = "INT NOT NULL")
   private int medicationId;

   @OneToOne
   @JoinColumn(name = "medication_id")
   private Medication medication;

   public DroneMedication() {
   }

   public DroneMedication(int droneId, int medicationId) {
      this.droneId = droneId;
      this.medicationId = medicationId;
   }

   public Medication getMedication() {
      return this.medication;
   }
}
