package com.example.divesanimaapi.exceptions;

import org.springframework.http.HttpStatus;

public class ArticleNotFoundException extends GlobalHttpException {

  @Override
  public String getMessage() {
    return "Article not found";
  }

  @Override
  public Integer getStatusCode() {
    return HttpStatus.NOT_FOUND.value();
  }
}
