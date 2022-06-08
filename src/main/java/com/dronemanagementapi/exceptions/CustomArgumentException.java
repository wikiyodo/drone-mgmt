package com.dronemanagementapi.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.FieldError;

public class CustomArgumentException extends Exception {
   private List<FieldError> fieldErrors;
   private String message;

   public CustomArgumentException(String message) {
      this.message = message;

      if (fieldErrors == null) {
         fieldErrors = new ArrayList<FieldError>();
      }
   }

   public CustomArgumentException(String fieldName, String fieldValue, String message) {
      FieldError error = new FieldError("empty", fieldName, fieldValue);
      this.message = message;

      if (fieldErrors == null) {
         fieldErrors = new ArrayList<FieldError>();
      }

      this.addError(error);
   }

   public void addError(String fieldName, String fieldValue) {
      FieldError error = new FieldError("empty", fieldName, fieldValue);
      this.addError(error);
   }

   public void addError(FieldError error) {
      fieldErrors.add(error);
   }

   public List<FieldError> getFieldErrors() {
      return fieldErrors;
   }

   public String getMessage() {
      return message;
   }

}
