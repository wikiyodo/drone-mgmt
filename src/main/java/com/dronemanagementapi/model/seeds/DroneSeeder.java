package com.dronemanagementapi.model.seeds;

import java.util.ArrayList;
import java.util.List;

import com.dronemanagementapi.model.Drone;
import com.dronemanagementapi.model.Medication;
import com.dronemanagementapi.repository.DroneRepository;
import com.dronemanagementapi.repository.MedicationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DroneSeeder {
   @Autowired
   private DroneRepository droneRepository;

   public DroneSeeder(DroneRepository droneRepository) {
      this.droneRepository = droneRepository;
   }

   public void run() {
      List<String[]> drones = new ArrayList<String[]>();

      String[] drone1 = { "DRONE-XLS23", "Lightweight", "100.6", "100", "IDLE" };
      String[] drone2 = { "DRONE-XLS24", "Middleweight", "236.6", "34.5", "LOADING" };
      String[] drone3 = { "DRONE-XLS25", "Lightweight", "130.6", "64.5", "IDLE" };
      String[] drone4 = { "DRONE-XLS26", "Middleweight", "250.6", "54.5", "IDLE" };
      String[] drone5 = { "DRONE-XLS27", "Cruiserweight", "300.6", "44.5", "IDLE" };
      String[] drone6 = { "DRONE-XLS28", "Lightweight", "160.6", "74.5", "IDLE" };
      String[] drone7 = { "DRONE-XLS29", "Lightweight", "100.6", "24.5", "IDLE" };
      String[] drone8 = { "DRONE-XLS33", "Cruiserweight", "340.6", "44.5", "IDLE" };
      String[] drone9 = { "DRONE-XLS43", "Lightweight", "100.6", "34.5", "IDLE" };
      String[] drone10 = { "DRONE-XLS53", "Middleweight", "230.6", "54.5", "IDLE" };
      String[] drone11 = { "DRONE-XLS63", "Lightweight", "143.6", "64.5", "LOADING" };
      String[] drone12 = { "DRONE-XLS73", "Cruiserweight", "310.6", "94.5", "IDLE" };
      String[] drone13 = { "DRONE-XLS83", "Lightweight", "60.6", "24", "IDLE" };
      String[] drone14 = { "DRONE-XLS93", "Lightweight", "180.6", "24", "IDLE" };
      String[] drone15 = { "DRONE-XLS44", "Middleweight", "234", "2", "LOADED" };
      String[] drone16 = { "DRONE-XLS55", "Heavyweight", "430", "24.5", "IDLE" };
      String[] drone17 = { "DRONE-XLS56", "Middleweight", "200.6", "36", "IDLE" };
      String[] drone18 = { "DRONE-XLS77", "Heavyweight", "500", "100", "IDLE" };

      drones.add(drone1);
      drones.add(drone2);
      drones.add(drone3);
      drones.add(drone4);
      drones.add(drone5);
      drones.add(drone6);
      drones.add(drone7);
      drones.add(drone8);
      drones.add(drone9);
      drones.add(drone10);
      drones.add(drone11);
      drones.add(drone12);
      drones.add(drone13);
      drones.add(drone14);
      drones.add(drone15);
      drones.add(drone16);
      drones.add(drone17);
      drones.add(drone18);

      for (int i = 0; i < drones.size(); i++) {
         String[] droneData = drones.get(i);

         Drone drone = new Drone();
         drone.setSerialNumber(droneData[0]);
         drone.setModel(droneData[1]);
         drone.setWeightLimit(Double.parseDouble(droneData[2]));
         drone.setBatteryCapacity(Double.parseDouble(droneData[3]));
         drone.setState(droneData[4]);
         droneRepository.save(drone);
      }
   }

}
