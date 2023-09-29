package com.example.divesanimaapi.exceptions;

import org.springframework.http.HttpStatus;

public class UnprocessableRequestException extends GlobalHttpException {

  @Override
  public String getMessage() {
    return "Invalid request payload";
  }

  @Override
  public Integer getStatusCode() {
    return HttpStatus.UNPROCESSABLE_ENTITY.value();
  }
}
