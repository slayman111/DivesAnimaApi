package com.example.divesanimaapi.exceptions;

public class LoginAlreadyExistsException extends RuntimeException {

  @Override
  public String getMessage() {
    return "Login already exists";
  }
}
