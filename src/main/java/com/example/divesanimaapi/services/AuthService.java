package com.example.divesanimaapi.services;

import com.example.divesanimaapi.dto.responses.auth.AuthResponse;
import com.example.divesanimaapi.exceptions.LoginAlreadyExistsException;
import com.example.divesanimaapi.models.entities.Role;
import com.example.divesanimaapi.models.entities.User;
import com.example.divesanimaapi.models.enums.RoleEnum;
import com.example.divesanimaapi.repositories.UserRepository;
import com.example.divesanimaapi.services.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final UserRepository userRepository;
  private final JwtService jwtService;
  private final PasswordEncoder passwordEncoder;
  private final AuthenticationManager authenticationManager;

  public AuthResponse authenticate(String login, String password) {
    Authentication authentication = authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(login, password)
    );

    User user = (User) authentication.getPrincipal();

    return new AuthResponse(user.getLogin(), user.getRole(), jwtService.generateToken(user));
  }

  public AuthResponse register(String login, String password) {
    userRepository
      .findByLogin(login)
      .ifPresent(user -> {
        throw new LoginAlreadyExistsException();
      });

    User user = userRepository.save(User.builder()
      .login(login)
      .password(passwordEncoder.encode(password))
      .role(new Role(RoleEnum.USER.getId(), RoleEnum.USER.name()))
      .build()
    );

    return new AuthResponse(user.getLogin(), user.getRole(), jwtService.generateToken(user));
  }
}
