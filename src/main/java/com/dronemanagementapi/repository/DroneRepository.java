package com.dronemanagementapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.dronemanagementapi.model.Drone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

@Transactional
public interface DroneRepository extends JpaRepository<Drone, String> {
   Drone findOneBySerialNumber(@Param("serial_number") int serialNumber);

   List<Drone> findAllByState(@Param("state") String state);
}
