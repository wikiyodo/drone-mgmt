package com.dronemanagementapi.repository;

import javax.transaction.Transactional;

import com.dronemanagementapi.model.Medication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
public interface DroneMedicationRepository extends JpaRepository<Medication, String> {

}
