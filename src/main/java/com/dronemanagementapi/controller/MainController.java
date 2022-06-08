package com.dronemanagementapi.controller;

import javax.validation.Valid;

import com.dronemanagementapi.data.request.DroneBySerialNumberRequest;
import com.dronemanagementapi.data.request.LoadDroneMedicationsRequest;
import com.dronemanagementapi.data.request.NewDroneRequest;
import com.dronemanagementapi.data.response.DroneBatteryResponse;
import com.dronemanagementapi.data.response.DroneMedicationsResponse;
import com.dronemanagementapi.data.response.DroneResponse;
import com.dronemanagementapi.data.response.DronesResponse;
import com.dronemanagementapi.data.response.GeneralResponse;
import com.dronemanagementapi.exceptions.CustomArgumentException;
import com.dronemanagementapi.service.DroneServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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
      HttpStatus status = HttpStatus.CREATED;

      try {
         DroneResponse newDrone = droneService.register(newDroneRequest);
         response.setMessage("Drone has been succesfully created");
         response.setStatus(true);
         response.setData(newDrone);
      } catch (Exception $e) {
         status = HttpStatus.BAD_REQUEST;
         response.setMessage($e.getMessage());
         response.setStatus(false);
      }

      return new ResponseEntity<GeneralResponse>(response, status);
   }

   @PostMapping(path = "/medications", consumes = "application/json", produces = "application/json")
   public ResponseEntity<GeneralResponse> loadMedicationsToDrone(
         @Valid @RequestBody LoadDroneMedicationsRequest loadDroneMedicationsRequest)
         throws Exception {
      GeneralResponse response = new GeneralResponse();
      HttpStatus status = HttpStatus.CREATED;

      try {
         DroneMedicationsResponse droneMedications = droneService.loadMedication(loadDroneMedicationsRequest);
         response.setMessage("Medications have been loaded!");
         response.setStatus(true);
         response.setData(droneMedications);
      } catch (CustomArgumentException $e) {
         response.setMessage($e.getMessage());
         response.setStatus(false);
         response.setError($e.getFieldErrors());
         status = HttpStatus.BAD_REQUEST;
      } catch (Exception $e) {
         response.setMessage($e.getMessage());
         response.setStatus(false);
         status = HttpStatus.BAD_REQUEST;
      }

      return new ResponseEntity<GeneralResponse>(response, status);
   }

   @GetMapping(path = "/medications", consumes = "application/json", produces = "application/json")
   public ResponseEntity<GeneralResponse> getDroneMedications(
         @Valid @RequestBody DroneBySerialNumberRequest droneBySerialNumberRequest)
         throws Exception {
      GeneralResponse response = new GeneralResponse();
      HttpStatus status = HttpStatus.OK;

      try {
         DroneMedicationsResponse droneMedications = droneService.getMedications(droneBySerialNumberRequest);
         response.setMessage("Medications have been loaded!");
         response.setStatus(true);
         response.setData(droneMedications);
      } catch (CustomArgumentException $e) {
         response.setMessage($e.getMessage());
         response.setStatus(false);
         response.setError($e.getFieldErrors());
         status = HttpStatus.NOT_FOUND;
      } catch (Exception $e) {
         response.setMessage($e.getMessage());
         response.setStatus(false);
         status = HttpStatus.NOT_ACCEPTABLE;
      }

      return new ResponseEntity<GeneralResponse>(response, status);
   }

   @GetMapping(path = "", consumes = "application/json", produces = "application/json")
   public ResponseEntity<GeneralResponse> getAvailableDrones()
         throws Exception {
      GeneralResponse response = new GeneralResponse();
      HttpStatus status = HttpStatus.OK;

      try {
         DronesResponse drones = droneService.getAvailableDrones();
         response.setMessage("Available drones!");
         response.setStatus(true);
         response.setData(drones);
      } catch (CustomArgumentException $e) {
         response.setMessage($e.getMessage());
         response.setStatus(false);
         response.setError($e.getFieldErrors());
         status = HttpStatus.NOT_FOUND;
      } catch (Exception $e) {
         response.setMessage($e.getMessage());
         response.setStatus(false);
         status = HttpStatus.NOT_ACCEPTABLE;
      }

      return new ResponseEntity<GeneralResponse>(response, status);
   }

   @GetMapping(path = "/battery", consumes = "application/json", produces = "application/json")
   public ResponseEntity<GeneralResponse> getDroneBatteryLevel(
         @Valid @RequestBody DroneBySerialNumberRequest droneBySerialNumberRequest)
         throws Exception {
      GeneralResponse response = new GeneralResponse();
      HttpStatus status = HttpStatus.OK;

      try {
         DroneBatteryResponse droneBattery = droneService.getBatteryLevel(droneBySerialNumberRequest);
         response.setMessage("Drone battery level returned");
         response.setStatus(true);
         response.setData(droneBattery);
      } catch (CustomArgumentException $e) {
         response.setMessage($e.getMessage());
         response.setStatus(false);
         response.setError($e.getFieldErrors());
         status = HttpStatus.NOT_FOUND;
      } catch (Exception $e) {
         response.setMessage($e.getMessage());
         response.setStatus(false);
         status = HttpStatus.NOT_ACCEPTABLE;
      }

      return new ResponseEntity<GeneralResponse>(response, HttpStatus.CREATED);
   }
}
