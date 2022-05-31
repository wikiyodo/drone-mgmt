package com.dronemanagementapi.repository;

import javax.transaction.Transactional;

import com.dronemanagementapi.model.DroneMedication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface MedicationRepository extends JpaRepository<DroneMedication, String> {

}
