package com.example.divesanimaapi.controllers;

import com.example.divesanimaapi.dto.requests.diary.ChangeDiaryRequest;
import com.example.divesanimaapi.dto.requests.diary.CreateDiaryRequest;
import com.example.divesanimaapi.services.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("api/diary")
@RequiredArgsConstructor
public class DiaryController {

  private final DiaryService diaryService;

  @GetMapping
  public ResponseEntity<?> getAll(@RequestParam LocalDate from, @RequestParam LocalDate to) {
    return ResponseEntity.ok(diaryService.getAll(from, to));
  }

  @PostMapping
  public ResponseEntity<?> create(@RequestBody CreateDiaryRequest createDiaryRequest) {
    return ResponseEntity.ok(diaryService.create(createDiaryRequest));
  }

  @PutMapping
  public ResponseEntity<?> change(@RequestBody ChangeDiaryRequest changeDiaryRequest) {
    return ResponseEntity.ok(diaryService.change(changeDiaryRequest));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Integer id) {
    return ResponseEntity.ok(diaryService.delete(id));
  }
}
