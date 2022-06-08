package com.dronemanagementapi.data.response;

public class CustomFieldError {
   private String fieldName;
   private String error;

   public CustomFieldError(String fieldName, String error) {
      this.fieldName = fieldName;
      this.error = error;
   }

   public String getFieldName() {
      return fieldName;
   }

   public String getError() {
      return error;
   }
}
