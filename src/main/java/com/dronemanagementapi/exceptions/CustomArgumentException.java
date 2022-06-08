package com.dronemanagementapi.exceptions;

import java.util.ArrayList;
import java.util.List;

import com.dronemanagementapi.data.response.CustomFieldError;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class CustomArgumentException extends Exception {
   private List<FieldError> fieldErrors;

   public CustomArgumentException(String fieldName, String fieldValue) {
      FieldError error = new FieldError("empty", fieldName, fieldValue);

      if (fieldErrors == null) {
         fieldErrors = new ArrayList<FieldError>();
      }

      this.addError(error);
   }

   public void addError(FieldError error) {
      fieldErrors.add(error);
   }

   public List<FieldError> getFieldErrors() {
      return fieldErrors;
   }
}
