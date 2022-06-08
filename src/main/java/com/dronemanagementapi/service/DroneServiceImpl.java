package com.dronemanagementapi.service;

import com.dronemanagementapi.data.request.NewDroneRequest;
import com.dronemanagementapi.data.response.DroneResponse;
import com.dronemanagementapi.enums.DroneState;
import com.dronemanagementapi.model.Drone;
import com.dronemanagementapi.repository.DroneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DroneServiceImpl {
   @Autowired
   private DroneRepository droneRepository;
   // @Autowired
   // private DroneMedicationRepository droneMedicationRepository;
   // @Autowired
   // private MedicationRepository medicationRepository;

   public DroneResponse register(NewDroneRequest newDroneRequest) {
      Drone drone = new Drone();
      drone.setBatteryCapacity(newDroneRequest.getBatteryCapacity());
      drone.setModel(newDroneRequest.getModel());
      drone.setSerialNumber(newDroneRequest.getSerialNumber());
      drone.setState(DroneState.IDLE.name());
      drone.setWeightLimit(newDroneRequest.getWeightLimit());
      droneRepository.save(drone);

      DroneResponse response = new DroneResponse();
      response.setBatteryCapacity(newDroneRequest.getBatteryCapacity());
      response.setModel(newDroneRequest.getModel().toString());
      response.setSerialNumber(newDroneRequest.getSerialNumber());
      response.setState(drone.getState());
      response.setWeightLimit(newDroneRequest.getWeightLimit());

      return response;
   }
}
