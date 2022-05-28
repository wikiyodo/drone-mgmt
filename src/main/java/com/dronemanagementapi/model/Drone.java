package com.dronemanagementapi.model;

import javax.persistence.Id;
import javax.persistence.Column;

public class Drone {
   @Id

   @Column(name = "serial_number", columnDefinition = "VARCHAR(100) NOT NULL")
   private String serialNumber;

   @Column(name = "MODEL", columnDefinition = "ENUM ('Lightweight', 'Middleweight', 'Cruiserweight', 'Heavyweight')")
   private String model;

   @Column(name = "weight_limit", precision = 2, scale = 2)
   private Double weightLimit;

   @Column(name = "batteryCapacity", precision = 2, scale = 2)
   private Double batteryCapacity;

   @Column(name = "MODEL", columnDefinition = "ENUM ('IDLE', 'LOADING', 'LOADED', 'DELIVERING', 'DELIVERED', 'RETURNING')")
   private String state;

   public Drone() {
   }

   public Drone(String serialNumber, String model, Double weightLimit, Double batteryCapacity, String state) {
      super();

      this.serialNumber = serialNumber;
      this.model = model;
      this.weightLimit = weightLimit;
      this.batteryCapacity = batteryCapacity;
      this.state = state;
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
