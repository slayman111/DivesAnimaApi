package com.example.divesanimaapi.services;

import com.example.divesanimaapi.models.Todo;
import com.example.divesanimaapi.repositories.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

  private final TodoRepository todoRepository;

  public List<Todo> findAllByUserId(Integer userId) {
    return todoRepository.findTodosByUsersId(userId);
  }
}
