package com.example.divesanimaapi.exceptions;

import org.springframework.http.HttpStatus;

public class TodoNotFoundException extends GlobalHttpException {

  @Override
  public String getMessage() {
    return "Todo item not found";
  }

  @Override
  public Integer getStatusCode() {
    return HttpStatus.NOT_FOUND.value();
  }
}
