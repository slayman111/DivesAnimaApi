package com.example.divesanimaapi.services;

import com.example.divesanimaapi.dto.requests.todo.ChangeTodoRequest;
import com.example.divesanimaapi.dto.requests.todo.CreateTodoRequest;
import com.example.divesanimaapi.exceptions.ObjectNotFoundException;
import com.example.divesanimaapi.exceptions.UnprocessableRequestException;
import com.example.divesanimaapi.models.entities.Todo;
import com.example.divesanimaapi.models.entities.User;
import com.example.divesanimaapi.repositories.TodoRepository;
import com.example.divesanimaapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TodoService {

  private final TodoRepository todoRepository;
  private final UserRepository userRepository;

  public List<Todo> findByUserId(Integer userId) {
    return todoRepository.findTodosByUsersId(userId);
  }

  public Todo create(CreateTodoRequest createTodoRequest) {
    User user = userRepository.findById(createTodoRequest.getUserId()).orElseThrow(ObjectNotFoundException::new);

    Set<Todo> todos = user.getTodos();
    Todo todo = Todo.builder()
      .record(createTodoRequest.getRecord())
      .completed(false)
      .build();
    todos.add(todo);
    user.setTodos(todos);

    todoRepository.save(todo);
    userRepository.save(user);

    return todo;
  }

  @SneakyThrows
  public Todo change(ChangeTodoRequest changeTodoRequest) {
    if (changeTodoRequest.getId() == null) {
      throw new UnprocessableRequestException();
    }

    Todo todo = todoRepository.findById(changeTodoRequest.getId()).orElseThrow(ObjectNotFoundException::new);

    if (changeTodoRequest.getRecord() == null) {
      todo.setCompleted(!todo.getCompleted());
    } else {
      todo.setRecord(changeTodoRequest.getRecord());
    }

    todoRepository.save(todo);

    return todo;
  }

  public Todo delete(Integer id) {
    Todo todo = todoRepository.findById(id).orElseThrow(ObjectNotFoundException::new);

    todoRepository.delete(todo);

    return todo;
  }
}
