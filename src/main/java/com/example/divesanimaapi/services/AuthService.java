package com.example.divesanimaapi.services;

import com.example.divesanimaapi.exceptions.LoginAlreadyExistsException;
import com.example.divesanimaapi.models.Role;
import com.example.divesanimaapi.models.enums.RoleEnum;
import com.example.divesanimaapi.models.User;
import com.example.divesanimaapi.repositories.RoleRepository;
import com.example.divesanimaapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final UserRepository userRepository;
  private final RoleRepository roleRepository;

  public Optional<User> getUserByLoginAndPassword(String login, String password) {
    return userRepository.findByLoginAndPassword(login, password);
  }

  public User registerUser(String login, String password) {
    userRepository
      .findByLogin(login)
      .ifPresent(user -> {
        throw new LoginAlreadyExistsException();
      });

    return userRepository.save(User.builder()
      .login(login)
      .password(password)
      .role(roleRepository
        .findById(RoleEnum.USER.getId())
        .orElse(new Role(RoleEnum.USER.getId(), RoleEnum.USER.name()))
      )
      .build()
    );
  }
}
