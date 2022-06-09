package com.dronemanagementapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.dronemanagementapi.model.Drone;
import com.dronemanagementapi.model.DroneMedication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Transactional
public interface DroneMedicationRepository extends JpaRepository<DroneMedication, String> {
   @Query(value = "SELECT m from DroneMedication m where m.drone =:drone ")
   List<DroneMedication> findByDrone(@Param("drone") Drone drone);
}
