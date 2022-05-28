package com.dronemanagementapi.repository;

import javax.transaction.Transactional;

import com.dronemanagementapi.model.Medication;

import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface MedicationRepository extends JpaRepository<Medication, String> {

}
