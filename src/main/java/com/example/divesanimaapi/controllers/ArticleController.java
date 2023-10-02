package com.example.divesanimaapi.controllers;

import com.example.divesanimaapi.models.dto.requests.article.CreateArticleRequest;
import com.example.divesanimaapi.services.ArticleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/article")
@RequiredArgsConstructor
public class ArticleController {

  private final ArticleService articleService;
  private final ObjectMapper objectMapper;

  @GetMapping
  public ResponseEntity<?> getPreviews() {
    return ResponseEntity.ok(articleService.getPreviews());
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable Integer id) {
    return ResponseEntity.ok(articleService.findById(id));
  }

  @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
  @SneakyThrows
  public ResponseEntity<?> create(
    @RequestPart("article") String article,
    @RequestPart("title_image") MultipartFile titleImage
  ) {
    CreateArticleRequest createArticleRequest = objectMapper.readValue(article, CreateArticleRequest.class);

    return ResponseEntity.ok(articleService.create(createArticleRequest, titleImage.getBytes()));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Integer id) {
    return ResponseEntity.ok(articleService.delete(id));
  }
}
