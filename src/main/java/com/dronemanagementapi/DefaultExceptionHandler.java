package com.dronemanagementapi;

import com.dronemanagementapi.data.response.GeneralResponse;
import com.dronemanagementapi.exceptions.CustomArgumentException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler {

   @ExceptionHandler(value = { MethodArgumentNotValidException.class })
   public ResponseEntity<GeneralResponse> handleException(MethodArgumentNotValidException ex) {

      return new ResponseEntity<GeneralResponse>(
            new GeneralResponse(false, "Validation failed", ex.getFieldErrors()),
            HttpStatus.BAD_REQUEST);
   }

   @ExceptionHandler(value = CustomArgumentException.class)
   public ResponseEntity<GeneralResponse> handleException(CustomArgumentException ex) {

      return new ResponseEntity<GeneralResponse>(
            new GeneralResponse(false, "Validation failed", ex.getFieldErrors()),
            HttpStatus.BAD_REQUEST);
   }

   @ExceptionHandler(value = { RuntimeException.class })
   public ResponseEntity<GeneralResponse> handleException(Exception ex) {

      return new ResponseEntity<GeneralResponse>(
            new GeneralResponse(false, ex.getMessage()),
            HttpStatus.BAD_REQUEST);
   }
}
