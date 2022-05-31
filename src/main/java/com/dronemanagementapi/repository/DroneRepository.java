package com.dronemanagementapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.dronemanagementapi.model.Drone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {
   Drone findOneBySerialNumber(@Param("serial_number") int serialNumber);

   List<Drone> findAllByState(@Param("state") String state);
}
