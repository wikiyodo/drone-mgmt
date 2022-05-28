package com.dronemanagementapi.repository;

import javax.transaction.Transactional;

import com.dronemanagementapi.model.DroneMedication;

import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface DroneMedicationRepository extends JpaRepository<DroneMedication, String> {

}
