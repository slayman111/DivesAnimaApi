package com.example.divesanimaapi.exceptions;

import org.springframework.http.HttpStatus;

public class ObjectNotFoundException extends GlobalHttpException {

  @Override
  public String getMessage() {
    return "Requested object not found";
  }

  @Override
  public Integer getStatusCode() {
    return HttpStatus.NOT_FOUND.value();
  }
}
