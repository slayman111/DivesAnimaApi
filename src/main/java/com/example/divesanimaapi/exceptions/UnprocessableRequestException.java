package com.example.divesanimaapi.exceptions;

public class UnprocessableRequestException extends Throwable {

  @Override
  public String getMessage() {
    return "Invalid request payload";
  }
}
