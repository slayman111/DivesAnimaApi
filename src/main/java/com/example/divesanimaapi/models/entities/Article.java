package com.example.divesanimaapi.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "articles")
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

  @PreRemove
  private void removeAssociations() {
    for (User user : this.getUsers()) {
      user.getArticles().remove(this);
    }
  }
}
