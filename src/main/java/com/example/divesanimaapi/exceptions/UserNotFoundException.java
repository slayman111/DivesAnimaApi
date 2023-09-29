package com.example.divesanimaapi.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends GlobalHttpException {

  @Override
  public String getMessage() {
    return "User not found";
  }

  @Override
  public Integer getStatusCode() {
    return HttpStatus.NOT_FOUND.value();
  }
}
