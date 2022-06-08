package com.dronemanagementapi.model;

import javax.persistence.Id;
import javax.persistence.Table;

import com.dronemanagementapi.enums.DroneModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "drones")
public class Drone {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id")
   private Integer id;

   @Column(name = "serial_number", columnDefinition = "VARCHAR(100) UNIQUE NOT NULL")
   private String serialNumber;

   @Column(name = "model", columnDefinition = "ENUM ('Lightweight', 'Middleweight', 'Cruiserweight', 'Heavyweight')")
   private DroneModel model;

   @Column(name = "weight_limit", precision = 2, scale = 2)
   private Double weightLimit;

   @Column(name = "battery_capacity", precision = 2, scale = 2)
   private Double batteryCapacity;

   @Column(name = "state", columnDefinition = "ENUM ('IDLE', 'LOADING', 'LOADED', 'DELIVERING', 'DELIVERED', 'RETURNING')")
   private String state;

   public Drone() {
   }

   public Drone(String serialNumber, DroneModel model, Double weightLimit, Double batteryCapacity, String state) {
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

   public void setModel(DroneModel model) {
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

   public DroneModel getModel() {
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
