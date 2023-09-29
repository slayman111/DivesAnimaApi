package com.example.divesanimaapi.exceptions;

import org.springframework.http.HttpStatus;

public class LoginAlreadyExistsException extends GlobalHttpException {

  @Override
  public String getMessage() {
    return "Login already exists";
  }

  @Override
  public Integer getStatusCode() {
    return HttpStatus.CONFLICT.value();
  }
}
