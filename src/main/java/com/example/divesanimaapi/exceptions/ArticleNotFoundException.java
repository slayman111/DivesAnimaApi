package com.example.divesanimaapi.exceptions;

public class ArticleNotFoundException extends RuntimeException {

  @Override
  public String getMessage() {
    return "Article not found";
  }
}
