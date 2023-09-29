package com.example.divesanimaapi.exceptions.handler;

import com.example.divesanimaapi.dto.responses.error.ErrorResponse;
import com.example.divesanimaapi.exceptions.GlobalHttpException;
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
