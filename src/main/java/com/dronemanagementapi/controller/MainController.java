package com.dronemanagementapi.controller;

import javax.validation.Valid;

import com.dronemanagementapi.data.request.LoadDroneMedicationsRequest;
import com.dronemanagementapi.data.request.NewDroneRequest;
import com.dronemanagementapi.data.response.DroneMedicationsResponse;
import com.dronemanagementapi.data.response.DroneResponse;
import com.dronemanagementapi.data.response.GeneralResponse;
import com.dronemanagementapi.exceptions.CustomArgumentException;
import com.dronemanagementapi.service.DroneServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/drone")
@Validated
public class MainController {
   @Autowired
   private DroneServiceImpl droneService;

   @PostMapping(path = "", consumes = "application/json", produces = "application/json")
   public ResponseEntity<GeneralResponse> addNewDrone(@Valid @RequestBody NewDroneRequest newDroneRequest)
         throws Exception {
      GeneralResponse response = new GeneralResponse();
      try {
         DroneResponse newDrone = droneService.register(newDroneRequest);
         response.setMessage("Drone has been succesfully created");
         response.setStatus(true);
         response.setData(newDrone);
      } catch (Exception $e) {
         response.setMessage($e.getMessage());
         response.setStatus(false);
      }

      return new ResponseEntity<GeneralResponse>(response, HttpStatus.CREATED);
   }

   @PostMapping(path = "/medications", consumes = "application/json", produces = "application/json")
   public ResponseEntity<GeneralResponse> loadMedicationsToDrone(
         @Valid @RequestBody LoadDroneMedicationsRequest loadDroneMedicationsRequest)
         throws Exception {
      GeneralResponse response = new GeneralResponse();

      try {
         DroneMedicationsResponse droneMedications = droneService.loadMedication(loadDroneMedicationsRequest);
         response.setMessage("Medications have been loaded!");
         response.setStatus(true);
         response.setData(droneMedications);
      } catch (CustomArgumentException $e) {
         response.setMessage($e.getMessage());
         response.setStatus(false);
         response.setError($e.getFieldErrors());
      } catch (Exception $e) {
         response.setMessage($e.getMessage());
         response.setStatus(false);
      }

      return new ResponseEntity<GeneralResponse>(response, HttpStatus.CREATED);
   }
}
