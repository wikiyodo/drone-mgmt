package com.dronemanagementapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.dronemanagementapi.model.Drone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

@Transactional
public interface DroneRepository extends JpaRepository<Drone, String> {

   List<Drone> findAllByState(@Param("drone_state") String state);

   @Query(value = "SELECT e from Drone e where e.serialNumber =:serialNumber ")
   Drone findBySerialNumber(@Param("serialNumber") String serialNumber);

   @Modifying
   @Query(value = "update Drone d set d.state = :state where  d.serialNumber= :serialNumber")
   void setUpdateState(@Param("state") String status, @Param("serialNumber") String serialNumber);

}
