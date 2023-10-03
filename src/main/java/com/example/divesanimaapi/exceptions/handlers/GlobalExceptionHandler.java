package com.example.divesanimaapi.exceptions.handlers;

import com.example.divesanimaapi.exceptions.GlobalHttpException;
import com.example.divesanimaapi.models.dto.responses.error.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(GlobalHttpException.class)
  public ResponseEntity<ErrorResponse> handleHttpException(GlobalHttpException ex) {
    return ResponseEntity
      .status(ex.getStatusCode())
      .body(new ErrorResponse(ex.getStatusCode(), ex.getMessage()));
  }
}
