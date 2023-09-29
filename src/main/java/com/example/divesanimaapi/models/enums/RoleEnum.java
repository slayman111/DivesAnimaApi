package com.example.divesanimaapi.models.enums;

public enum RoleEnum {

  USER(1), ADMIN(2);

  private final int id;

  RoleEnum(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }
}
