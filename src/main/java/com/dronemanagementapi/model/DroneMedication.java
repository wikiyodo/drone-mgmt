package com.dronemanagementapi.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "drone_medications")
public class DroneMedication {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id")
   private Integer id;

   @OneToOne
   @JoinColumn(name = "medication_id", referencedColumnName = "id")
   private Medication medication;

   @OneToOne
   @JoinColumn(name = "drone_id", referencedColumnName = "id")
   private Drone drone;

   @Column(name = "created_at", columnDefinition = "DATETIME", nullable = false)
   private LocalDateTime createdDate;

   @Column(name = "completed_at", columnDefinition = "DATETIME", nullable = false)
   private LocalDateTime completedDate;

   public DroneMedication() {
   }

   public DroneMedication(Drone drone, Medication medication) {
      super();

      this.drone = drone;
      this.medication = medication;
   }

   public Medication getMedication() {
      return this.medication;
   }
}
