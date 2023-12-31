package com.example.divesanimaapi.models.dto.requests.article;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateArticleRequest {

  @JsonProperty("title_text")
  private String titleText;
  private String text;
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate date;
}
