package com.example.divesanimaapi.models.dto.responses.auth;

import com.example.divesanimaapi.models.entities.Role;
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
  private String token;
}
