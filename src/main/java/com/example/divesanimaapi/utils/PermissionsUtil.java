package com.example.divesanimaapi.utils;

import com.example.divesanimaapi.exceptions.ObjectNotFoundException;
import com.example.divesanimaapi.exceptions.PermissionDeniedException;
import com.example.divesanimaapi.models.entities.User;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class PermissionsUtil {

  private static User getRelatedUser(Set<User> users) {
    return users.stream().findFirst().orElseThrow(ObjectNotFoundException::new);
  }

  public static void checkUserPermissions(Set<User> users, String login) {
    if (!getRelatedUser(users).getLogin().equals(login)) {
      throw new PermissionDeniedException();
    }
  }
}
