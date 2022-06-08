package com.dronemanagementapi.data.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.springframework.validation.FieldError;

public class GeneralResponse {
   private boolean status;
   private String message;
   private GeneralData data;

   @JsonInclude(JsonInclude.Include.ALWAYS)
   private List<FieldError> errors;

   public GeneralResponse(boolean status, String message) {
      this.message = message;
      this.status = status;
   }

   public GeneralResponse(boolean status, String message, List<FieldError> errors) {
      this.message = message;
      this.status = status;
      this.errors = errors;
   }

   public GeneralResponse() {

   }

   public void setMessage(String message) {
      this.message = message;
   }

   public void setStatus(boolean status) {
      this.status = status;
   }

   public void setData(GeneralData data) {
      this.data = data;
   }

   public void setError(List<FieldError> errors) {
      this.errors = errors;
   }

   public boolean getStatus() {
      return status;
   }

   public String getMessage() {
      return message;
   }

   public GeneralData getData() {
      return data;
   }

   public List<CustomFieldError> getErrors() {
      if (errors == null || errors.size() == 0) {

         return null;
      }

      List<CustomFieldError> customFieldErrors = new ArrayList<CustomFieldError>();

      for (int i = 0; i < errors.size(); i++) {
         FieldError error = errors.get(i);

         customFieldErrors.add(new CustomFieldError(error.getField(),
               error.getDefaultMessage()));
      }

      return customFieldErrors;
   }

}
