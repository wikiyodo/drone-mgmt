package com.dronemanagementapi.data.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.dronemanagementapi.enums.DroneModel;

import org.hibernate.validator.constraints.Length;

public class NewDroneRequest {

   @NotEmpty(message = "Serial number cannot be empty")
   @Length(max = 100, message = "Serial number cannot contain more than 100 characters")
   private String serialNumber;

   @NotNull(message = "Please specify the drone model")
   @Pattern(regexp = "Lightweight|Middleweight|Cruiserweight|Heavyweight", message = "We currently support one of these drone models: Lightweight, Middleweight, Cruiserweight, Heavyweight")
   private String model;

   @NotNull(message = "Weight limit cannot be empty")
   @Max(value = 500, message = "We only support drones with less than 500gr")
   @Min(value = 1, message = "Provide a valid weight limit (> 1gr)")
   private Double weightLimit;

   @NotNull(message = "Battery capacity cannot be empty")
   @Max(value = 100, message = "Battery capacity between 1% and 100%")
   @Min(value = 1, message = "Battery capacity between 1% and 100%")
   private Double batteryCapacity;

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

   public String getSerialNumber() {
      return serialNumber;
   }

   public DroneModel getModel() {
      return DroneModel.valueOf(model);
   }

   public Double getWeightLimit() {
      return weightLimit;
   }

   public Double getBatteryCapacity() {
      return batteryCapacity;
   }

}
