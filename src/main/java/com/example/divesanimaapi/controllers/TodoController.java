package com.example.divesanimaapi.controllers;

import com.example.divesanimaapi.services.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/todo")
@RequiredArgsConstructor
public class TodoController {

  private final TodoService todoService;

  @GetMapping("/{user-id}")
  public ResponseEntity<?> getAll(@PathVariable("user-id") Integer userId) {
    return ResponseEntity.ok(todoService.findAllByUserId(userId));
  }
}
