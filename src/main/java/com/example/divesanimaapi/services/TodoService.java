package com.example.divesanimaapi.services;

import com.example.divesanimaapi.exceptions.ObjectNotFoundException;
import com.example.divesanimaapi.exceptions.UnprocessableRequestException;
import com.example.divesanimaapi.models.dto.requests.todo.ChangeTodoRequest;
import com.example.divesanimaapi.models.dto.requests.todo.CreateTodoRequest;
import com.example.divesanimaapi.models.entities.Todo;
import com.example.divesanimaapi.models.entities.User;
import com.example.divesanimaapi.repositories.TodoRepository;
import com.example.divesanimaapi.repositories.UserRepository;
import com.example.divesanimaapi.utils.PermissionsUtil;
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

  public List<Todo> findByLogin(String login) {
    return todoRepository.findTodosByUsersLogin(login);
  }

  public Todo create(CreateTodoRequest createTodoRequest, String login) {
    User user = userRepository.findByLogin(login).orElseThrow(ObjectNotFoundException::new);

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
  public Todo change(ChangeTodoRequest changeTodoRequest, String login) {
    if (changeTodoRequest.getId() == null) {
      throw new UnprocessableRequestException();
    }

    Todo todo = todoRepository.findById(changeTodoRequest.getId()).orElseThrow(ObjectNotFoundException::new);
    PermissionsUtil.checkUserPermissions(todo.getUsers(), login);

    if (changeTodoRequest.getRecord() == null) {
      todo.setCompleted(!todo.getCompleted());
    } else {
      todo.setRecord(changeTodoRequest.getRecord());
    }

    todoRepository.save(todo);

    return todo;
  }

  public Todo delete(Integer id, String login) {
    Todo todo = todoRepository.findById(id).orElseThrow(ObjectNotFoundException::new);
    PermissionsUtil.checkUserPermissions(todo.getUsers(), login);

    todoRepository.delete(todo);

    return todo;
  }
}
