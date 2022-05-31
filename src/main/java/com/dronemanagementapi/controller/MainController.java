package com.dronemanagementapi.controller;

import com.dronemanagementapi.data.request.NewDroneRequest;
import com.dronemanagementapi.data.response.DroneResponse;
import com.dronemanagementapi.services.DroneService;
import com.dronemanagementapi.services.DroneServiceImpl;

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
@RequestMapping(path = "/v1/api/drone")
@Validated
public class MainController {
   @Autowired
   private DroneServiceImpl droneService;

   @GetMapping(path = "/", consumes = "application/json", produces = "application/json")
   public ResponseEntity<DroneResponse> addNewDrone(@RequestBody NewDroneRequest newDroneRequest) {
      DroneResponse newDrone = droneService.register(newDroneRequest);

      return new ResponseEntity<DroneResponse>(newDrone, HttpStatus.CREATED);
   }
}
