package com.dronemanagementapi.service;

import java.util.ArrayList;
import java.util.List;

import com.dronemanagementapi.data.request.DroneBySerialNumberRequest;
import com.dronemanagementapi.data.request.LoadDroneMedicationsRequest;
import com.dronemanagementapi.data.request.NewDroneRequest;
import com.dronemanagementapi.data.response.DroneBatteryResponse;
import com.dronemanagementapi.data.response.DroneMedicationsResponse;
import com.dronemanagementapi.data.response.DroneResponse;
import com.dronemanagementapi.data.response.DronesResponse;
import com.dronemanagementapi.enums.DroneState;
import com.dronemanagementapi.exceptions.CustomArgumentException;
import com.dronemanagementapi.model.Drone;
import com.dronemanagementapi.model.DroneMedication;
import com.dronemanagementapi.model.Medication;
import com.dronemanagementapi.model.seeds.DroneSeeder;
import com.dronemanagementapi.model.seeds.MedicationSeeder;
import com.dronemanagementapi.repository.DroneMedicationRepository;
import com.dronemanagementapi.repository.DroneRepository;
import com.dronemanagementapi.repository.MedicationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class DroneServiceImpl {
   @Autowired
   private DroneRepository droneRepository;
   @Autowired
   private DroneMedicationRepository droneMedicationRepository;
   @Autowired
   private MedicationRepository medicationRepository;

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

   public DroneMedicationsResponse loadMedication(LoadDroneMedicationsRequest loadDroneMedicationsRequest)
         throws CustomArgumentException {
      List<Medication> medications = new ArrayList<Medication>();
      Drone drone = droneRepository.findBySerialNumber(loadDroneMedicationsRequest.getSerialNumber());
      List<String> medicationCodes = loadDroneMedicationsRequest.getMedicationCodes();
      DroneMedicationsResponse response = new DroneMedicationsResponse();
      Double totalMedicationSize = 0.0;

      if (drone == null) {
         throw new CustomArgumentException("serialNumber",
               "Could not locate drone with the serial number: " + loadDroneMedicationsRequest.getSerialNumber(),
               "Error in provided data");
      }

      if (drone.getBatteryCapacity() < 25.0) {
         throw new CustomArgumentException("batteryLevel",
               drone.getBatteryCapacity() + "%",
               "Battery Low! battery level below 25%");
      }

      drone.setState("LOADING");
      droneRepository.save(drone);

      for (int i = 0; i < medicationCodes.size(); i++) {
         Medication medication = medicationRepository.findByCode(medicationCodes.get(i));

         if (medication == null) {
            throw new CustomArgumentException("serialNumber",
                  "Could not locate medication with the code: " + medicationCodes.get(i),
                  "Error in provided data");
         }

         totalMedicationSize += medication.getWeight();
         medications.add(medication);
      }

      if (totalMedicationSize > drone.getWeightLimit()) {
         CustomArgumentException error = new CustomArgumentException("Drone overloaded!");
         error.addError("droneWeightLimit", drone.getWeightLimit() + "");
         error.addError("medicationTotalSize", totalMedicationSize + "");
         throw error;
      }

      for (int i = 0; i < medications.size(); i++) {
         DroneMedication droneMedication = new DroneMedication();
         droneMedication.setDrone(drone);
         droneMedication.setMedication(medications.get(i));
         droneMedication.setCreatedDate();
         droneMedicationRepository.save(droneMedication);
      }

      drone.setState("LOADED");
      droneRepository.save(drone);

      response.setDrone(drone);
      response.setMedications(medications);

      return response;
   }

   public DroneMedicationsResponse getMedications(DroneBySerialNumberRequest droneBySerialNumberRequest)
         throws CustomArgumentException {
      Drone drone = droneRepository.findBySerialNumber(droneBySerialNumberRequest.getSerialNumber());
      DroneMedicationsResponse response = new DroneMedicationsResponse();

      if (drone == null) {
         throw new CustomArgumentException("serialNumber",
               "Could not locate drone with the serial number: " + droneBySerialNumberRequest.getSerialNumber(),
               "Error in provided data");
      }

      List<DroneMedication> droneMedications = droneMedicationRepository.findByDrone(drone);
      List<Medication> medications = new ArrayList<Medication>();

      for (int i = 0; i < droneMedications.size(); i++) {
         Medication medication = droneMedications.get(i).getMedication();

         medications.add(medication);
      }

      response.setDrone(drone);
      response.setMedications(medications);

      return response;
   }

   public DronesResponse getAvailableDrones()
         throws CustomArgumentException {
      List<Drone> drones = droneRepository.findAllByState("IDLE");
      DronesResponse response = new DronesResponse();

      response.setDrones(drones);

      return response;
   }

   public DroneBatteryResponse getBatteryLevel(DroneBySerialNumberRequest droneBySerialNumberRequest)
         throws CustomArgumentException {
      Drone drone = droneRepository.findBySerialNumber(droneBySerialNumberRequest.getSerialNumber());
      DroneBatteryResponse response = new DroneBatteryResponse();

      if (drone == null) {
         throw new CustomArgumentException("serialNumber",
               "Could not locate drone with the serial number: " + droneBySerialNumberRequest.getSerialNumber(),
               "Error in provided data");
      }

      response.setBatteryCapacity(drone.getBatteryCapacity());
      response.setSerialNumber(drone.getSerialNumber());

      return response;
   }

   @EventListener
   public void seed(ContextRefreshedEvent event) {
      MedicationSeeder medicationSeeder = new MedicationSeeder(medicationRepository);
      DroneSeeder droneSeeder = new DroneSeeder(droneRepository);

      medicationSeeder.run();
      droneSeeder.run();
   }
}
