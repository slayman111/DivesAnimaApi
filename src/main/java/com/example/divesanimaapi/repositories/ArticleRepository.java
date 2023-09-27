package com.example.divesanimaapi.repositories;

import com.example.divesanimaapi.dto.responses.ArticlePreviewResponse;
import com.example.divesanimaapi.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

  List<ArticlePreviewResponse> getAllProjectedBy();
}
