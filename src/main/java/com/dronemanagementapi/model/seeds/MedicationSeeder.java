package com.dronemanagementapi.model.seeds;

import java.util.ArrayList;
import java.util.List;

import com.dronemanagementapi.model.Medication;
import com.dronemanagementapi.repository.MedicationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicationSeeder {
   @Autowired
   private MedicationRepository medicationRepository;

   public MedicationSeeder(MedicationRepository medicationRepository) {
      this.medicationRepository = medicationRepository;
   }

   public void run() {
      List<String[]> medications = new ArrayList<String[]>();

      String[] medication1 = { "Medication 1", "20.5", "MED1", "http://medication1.url" };
      String[] medication2 = { "Medication 2", "60", "MED2", "http://medication1.url" };
      String[] medication3 = { "Medication 3", "100", "MED3", "http://medication1.url" };
      String[] medication4 = { "Medication 4", "6", "MED4", "http://medication1.url" };
      String[] medication5 = { "Medication 5", "10.5", "MED5", "http://medication1.url" };
      String[] medication6 = { "Medication 6", "23.5", "MED6", "http://medication1.url" };
      String[] medication7 = { "Medication 7", "26.5", "MED7", "http://medication1.url" };
      String[] medication8 = { "Medication 8", "20.5", "MED8", "http://medication1.url" };
      String[] medication9 = { "Medication 9", "20.5", "MED9", "http://medication1.url" };
      String[] medication10 = { "Medication 10", "50.5", "MED10", "http://medication1.url" };
      String[] medication11 = { "Medication 11", "40.5", "MED11", "http://medication1.url" };
      String[] medication12 = { "Medication 12", "80.5", "MED12", "http://medication1.url" };
      String[] medication13 = { "Medication 13", "70.5", "MED13", "http://medication1.url" };

      medications.add(medication1);
      medications.add(medication2);
      medications.add(medication3);
      medications.add(medication4);
      medications.add(medication5);
      medications.add(medication6);
      medications.add(medication7);
      medications.add(medication8);
      medications.add(medication9);
      medications.add(medication10);
      medications.add(medication11);
      medications.add(medication12);
      medications.add(medication13);

      for (int i = 0; i < medications.size(); i++) {
         String[] med = medications.get(i);

         Medication medication = new Medication();
         medication.setCode(med[2]);
         medication.setImageUrl(med[3]);
         medication.setName(med[0]);
         medication.setWeight(Double.parseDouble(med[1]));
         medicationRepository.save(medication);
      }
   }

}
