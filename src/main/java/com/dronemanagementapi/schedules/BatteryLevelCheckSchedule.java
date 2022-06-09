package com.dronemanagementapi.schedules;

import java.util.List;

import com.dronemanagementapi.model.Drone;
import com.dronemanagementapi.repository.DroneRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class BatteryLevelCheckSchedule {
   @Autowired
   private DroneRepository droneRepository;

   static final Logger logger = LoggerFactory.getLogger(BatteryLevelCheckSchedule.class);

   @Scheduled(fixedRate = 2000)
   public void runBatteryCheck() throws Exception {
      List<Drone> drones = droneRepository.findAll();

      for (int i = 0; i < drones.size(); i++) {
         Drone drone = drones.get(i);

         logger.info("serialNumber: {}, batteryLevel: {}, timestamp: {}", drone.getSerialNumber(),
               drone.getBatteryCapacity() + "%", java.time.LocalDateTime.now().toString());
      }
   }
}
