package com.example.divesanimaapi.services;

import com.example.divesanimaapi.dto.requests.CreateArticleRequest;
import com.example.divesanimaapi.dto.responses.ArticlePreviewResponse;
import com.example.divesanimaapi.exceptions.ArticleNotFoundException;
import com.example.divesanimaapi.models.Article;
import com.example.divesanimaapi.repositories.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleService {

  private final ArticleRepository articleRepository;

  public Article create(CreateArticleRequest createArticleRequest, byte[] titleImage) {
    return articleRepository.save(Article.builder()
      .titleText(createArticleRequest.getTitleText())
      .titleImage(titleImage)
      .text(createArticleRequest.getText())
      .date(createArticleRequest.getDate())
      .build()
    );
  }

  public List<ArticlePreviewResponse> getPreviews() {
    return articleRepository.findAll().stream().map(article ->
      new ArticlePreviewResponse(article.getId(), article.getText(), article.getTitleImage()))
      .collect(Collectors.toList());
  }

  public Article findById(Integer id) {
    return articleRepository
      .findById(id)
      .orElseThrow(ArticleNotFoundException::new);
  }
}
