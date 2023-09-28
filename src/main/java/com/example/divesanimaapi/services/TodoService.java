package com.example.divesanimaapi.services;

import com.example.divesanimaapi.dto.requests.todo.CreateTodoRecordRequest;
import com.example.divesanimaapi.dto.requests.todo.ChangeTodoRecordRequest;
import com.example.divesanimaapi.exceptions.TodoNotFoundException;
import com.example.divesanimaapi.exceptions.UnprocessableRequestException;
import com.example.divesanimaapi.exceptions.UserNotFoundException;
import com.example.divesanimaapi.models.Todo;
import com.example.divesanimaapi.models.User;
import com.example.divesanimaapi.repositories.TodoRepository;
import com.example.divesanimaapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class TodoService {

  private final TodoRepository todoRepository;
  private final UserRepository userRepository;

  public List<Todo> findByUserId(Integer userId) {
    return todoRepository.findTodosByUsersId(userId);
  }

  public Todo create(CreateTodoRecordRequest createTodoRecordRequest) {
    User user = userRepository.findById(createTodoRecordRequest.getUserId()).orElseThrow(UserNotFoundException::new);

    Set<Todo> todos = user.getTodos();
    Todo todo = Todo.builder()
      .record(createTodoRecordRequest.getRecord())
      .completed(false)
      .build();
    todos.add(todo);
    user.setTodos(todos);

    todoRepository.save(todo);
    userRepository.save(user);

    return todo;
  }

  @SneakyThrows
  public Todo change(ChangeTodoRecordRequest changeTodoRecordRequest) {
    if (changeTodoRecordRequest.getId() == null) {
      throw new UnprocessableRequestException();
    }

    Todo todo = todoRepository.findById(changeTodoRecordRequest.getId()).orElseThrow(TodoNotFoundException::new);

    if (changeTodoRecordRequest.getRecord() == null) {
      todo.setCompleted(!todo.getCompleted());
    } else {
      todo.setRecord(changeTodoRecordRequest.getRecord());
    }

    todoRepository.save(todo);

    return todo;
  }

  public Todo delete(Integer id) {
    Todo todo = todoRepository.findById(id).orElseThrow(TodoNotFoundException::new);

    todoRepository.delete(todo);

    return todo;
  }
}
