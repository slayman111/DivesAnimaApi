package com.example.divesanimaapi.dto.responses.auth;

import com.example.divesanimaapi.models.Role;
import com.example.divesanimaapi.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

  private String login;
  private Role role;

  public AuthResponse(User user) {
    this.login = user.getLogin();
    this.role = user.getRole();
  }
}
