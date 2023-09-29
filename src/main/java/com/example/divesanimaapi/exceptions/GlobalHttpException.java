package com.example.divesanimaapi.exceptions;

public abstract class GlobalHttpException extends RuntimeException {

  public abstract Integer getStatusCode();
}
