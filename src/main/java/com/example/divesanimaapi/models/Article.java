package com.example.divesanimaapi.models;

import com.example.divesanimaapi.dto.responses.ArticlePreviewResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "articles")
//@NamedNativeQuery(name = "Article.findByTitleTextNotNull",
//  query = "SELECT a.id as id, a.title_text as titleText, a.title_image as titleImage FROM articles a",
//  resultSetMapping = "Mapping.ArticlePreviewResponse")
//@SqlResultSetMapping(name = "Mapping.ArticlePreviewResponse",
//  classes = @ConstructorResult(targetClass = ArticlePreviewResponse.class,
//    columns = {@ColumnResult(name = "id"),
//      @ColumnResult(name = "titleText"),
//      @ColumnResult(name = "titleImage")}))
public class Article {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "title_text", length = 50, nullable = false)
  private String titleText;

  @Column(name = "title_image")
  private byte[] titleImage;

  @Column(name = "text", nullable = false)
  private String text;

  @Column(name = "date", nullable = false)
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate date;

  @JsonIgnore
  @ManyToMany(mappedBy = "articles")
  private Set<User> users;
}
