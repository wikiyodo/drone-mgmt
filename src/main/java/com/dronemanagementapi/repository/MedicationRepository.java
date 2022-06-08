package com.dronemanagementapi.repository;

import javax.transaction.Transactional;

import com.dronemanagementapi.model.Medication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Transactional
public interface MedicationRepository extends JpaRepository<Medication, String> {

   @Query(value = "SELECT m from Medication m where m.code =:code ")
   Medication findByCode(@Param("code") String code);
}
