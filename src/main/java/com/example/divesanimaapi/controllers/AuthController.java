package com.example.divesanimaapi.controllers;

import com.example.divesanimaapi.models.dto.requests.auth.AuthRequest;
import com.example.divesanimaapi.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
    return ResponseEntity.ok(
      authService.authenticate(authRequest.getLogin(), authRequest.getPassword())
    );
  }

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody AuthRequest authRequest) {
    return ResponseEntity.ok(
      authService.register(authRequest.getLogin(), authRequest.getPassword())
    );
  }
}
