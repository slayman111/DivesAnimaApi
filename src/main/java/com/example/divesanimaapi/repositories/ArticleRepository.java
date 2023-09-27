package com.example.divesanimaapi.repositories;

import com.example.divesanimaapi.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

  @Query("select a from Article a")
  <T> List<T> getAllBy(Class<T> type);
}
