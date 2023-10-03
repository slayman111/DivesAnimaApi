package com.example.divesanimaapi.exceptions;

import org.springframework.http.HttpStatus;

public class PermissionDeniedException extends GlobalHttpException {

  @Override
  public String getMessage() {
    return "You do not have access right to receive this object";
  }

  @Override
  public Integer getStatusCode() {
    return HttpStatus.FORBIDDEN.value();
  }
}
