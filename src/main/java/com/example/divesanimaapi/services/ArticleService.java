package com.example.divesanimaapi.services;

import com.example.divesanimaapi.dto.requests.CreateArticleRequest;
import com.example.divesanimaapi.dto.responses.ArticlePreviewResponse;
import com.example.divesanimaapi.models.Article;
import com.example.divesanimaapi.repositories.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
    return articleRepository.getAllProjectedBy();
  }
}
