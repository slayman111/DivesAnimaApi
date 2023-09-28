package com.example.divesanimaapi.controllers;

import com.example.divesanimaapi.dto.requests.todo.ChangeTodoRecordRequest;
import com.example.divesanimaapi.dto.requests.todo.CreateTodoRecordRequest;
import com.example.divesanimaapi.services.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/todo")
@RequiredArgsConstructor
public class TodoController {

  private final TodoService todoService;

  @GetMapping("/{user-id}")
  public ResponseEntity<?> getAll(@PathVariable("user-id") Integer userId) {
    return ResponseEntity.ok(todoService.findByUserId(userId));
  }

  @PostMapping
  public ResponseEntity<?> create(@RequestBody CreateTodoRecordRequest createTodoRecordRequest) {
    return ResponseEntity.ok(todoService.create(createTodoRecordRequest));
  }

  @PatchMapping
  public ResponseEntity<?> change(@RequestBody ChangeTodoRecordRequest changeTodoRecordRequest) {
    return ResponseEntity.ok(todoService.change(changeTodoRecordRequest));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Integer id) {
    return ResponseEntity.ok(todoService.delete(id));
  }
}
