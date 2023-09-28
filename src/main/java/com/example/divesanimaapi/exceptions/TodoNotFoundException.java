package com.example.divesanimaapi.exceptions;

public class TodoNotFoundException extends RuntimeException {

  @Override
  public String getMessage() {
    return "Todo item not found";
  }
}
