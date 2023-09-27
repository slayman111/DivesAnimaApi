package com.example.divesanimaapi.exceptions.handler;

import com.example.divesanimaapi.dto.responses.ErrorResponse;
import com.example.divesanimaapi.exceptions.LoginAlreadyExistsException;
import com.example.divesanimaapi.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(LoginAlreadyExistsException.class)
  public ResponseEntity<ErrorResponse> handleApplicationException(LoginAlreadyExistsException ex) {
    return ResponseEntity
      .status(HttpStatus.CONFLICT)
      .body(new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage()));
  }

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleApplicationException(UserNotFoundException ex) {
    return ResponseEntity
      .status(HttpStatus.NOT_FOUND)
      .body(new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage()));
  }
}
