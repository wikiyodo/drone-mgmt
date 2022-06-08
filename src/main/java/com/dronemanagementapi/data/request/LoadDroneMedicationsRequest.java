package com.dronemanagementapi.data.request;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class LoadDroneMedicationsRequest extends DroneBySerialNumberRequest {
   @NotEmpty(message = "Please provide medications to load into drone")
   @Valid
   private List<@Pattern(regexp = ".*") String> medicationCodes;

   public void setMedicationCodes(List<String> medicationCodes) {
      this.medicationCodes = medicationCodes;
   }

   public List<String> getMedicationCodes() {

      return medicationCodes;
   }

}
