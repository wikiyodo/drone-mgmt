package com.dronemanagementapi.model;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "medications")
public class Medication {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id")
   private Integer id;

   @Column(name = "name", columnDefinition = "VARCHAR(500) NOT NULL")
   private String name;

   @Column(name = "weight", precision = 2, scale = 2)
   private Double weight;

   @Column(name = "code", columnDefinition = "VARCHAR(500) NOT NULL")
   private String code;

   @Column(name = "image_url", columnDefinition = "TEXT", nullable = true)
   private String image;

   public Medication() {
   }

   public Medication(String name, Double weight, String code, String image) {
      super();

      this.name = name;
      this.weight = weight;
      this.code = code;
      this.image = image;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setWeight(Double weight) {
      this.weight = weight;
   }

   public void setCode(String code) {
      this.code = code;
   }

   public void setImageUrl(String image) {
      this.image = image;
   }

   public String getName() {
      return name;
   }

   public Double getWeight() {
      return weight;
   }

   public String getCode() {
      return code;
   }

   public String getImageUrl() {
      return image;
   }
}
