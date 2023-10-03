package com.example.divesanimaapi.controllers;

import com.example.divesanimaapi.models.dto.requests.diary.ChangeDiaryRequest;
import com.example.divesanimaapi.models.dto.requests.diary.CreateDiaryRequest;
import com.example.divesanimaapi.services.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;

@RestController
@RequestMapping("api/diary")
@RequiredArgsConstructor
public class DiaryController {

  private final DiaryService diaryService;

  @GetMapping
  public ResponseEntity<?> getAll(
    @RequestParam LocalDate from,
    @RequestParam LocalDate to,
    Principal principal
  ) {
    return ResponseEntity.ok(diaryService.getAll(principal.getName(), from, to));
  }

  @PostMapping
  public ResponseEntity<?> create(@RequestBody CreateDiaryRequest createDiaryRequest, Principal principal) {
    return ResponseEntity.ok(diaryService.create(createDiaryRequest, principal.getName()));
  }

  @PatchMapping
  public ResponseEntity<?> change(@RequestBody ChangeDiaryRequest changeDiaryRequest, Principal principal) {
    return ResponseEntity.ok(diaryService.change(changeDiaryRequest, principal.getName()));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Integer id, Principal principal) {
    return ResponseEntity.ok(diaryService.delete(id, principal.getName()));
  }
}
