package com.example.divesanimaapi.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArticlePreviewResponse {

  private Integer id;

  private String titleText;

  private byte[] titleImage;

}
