package com.example.divesanimaapi.controllers;

import com.example.divesanimaapi.services.DailyImageService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/daily-image")
@RequiredArgsConstructor
public class DailyImageController {

  private final DailyImageService dailyImageService;

  @PostMapping
  @SneakyThrows
  public ResponseEntity<?> create(@RequestParam("daily_image") MultipartFile dailyImage) {
    return ResponseEntity.ok(dailyImageService.create(dailyImage.getBytes()));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Integer id) {
    return ResponseEntity.ok(dailyImageService.delete(id));
  }
}
