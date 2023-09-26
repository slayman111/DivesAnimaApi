package com.example.divesanimaapi.dto.responses;

import com.example.divesanimaapi.models.Role;
import com.example.divesanimaapi.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
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
