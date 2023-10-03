package com.example.divesanimaapi.controllers;

import com.example.divesanimaapi.models.dto.requests.todo.ChangeTodoRequest;
import com.example.divesanimaapi.models.dto.requests.todo.CreateTodoRequest;
import com.example.divesanimaapi.services.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("api/todo")
@RequiredArgsConstructor
public class TodoController {

  private final TodoService todoService;

  @GetMapping
  public ResponseEntity<?> getAll(Principal principal) {
    return ResponseEntity.ok(todoService.findByLogin(principal.getName()));
  }

  @PostMapping
  public ResponseEntity<?> create(@RequestBody CreateTodoRequest createTodoRequest, Principal principal) {
    return ResponseEntity.ok(todoService.create(createTodoRequest, principal.getName()));
  }

  @PatchMapping
  public ResponseEntity<?> change(@RequestBody ChangeTodoRequest changeTodoRequest, Principal principal) {
    return ResponseEntity.ok(todoService.change(changeTodoRequest, principal.getName()));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Integer id, Principal principal) {
    return ResponseEntity.ok(todoService.delete(id, principal.getName()));
  }
}
