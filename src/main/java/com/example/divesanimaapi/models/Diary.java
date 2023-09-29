package com.example.divesanimaapi.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "diaries")
public class Diary {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "date", nullable = false)
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate date;

  @Column(name = "record", nullable = false)
  private String record;

  @Column(name = "completed", nullable = false)
  private Boolean completed = false;

  @JsonIgnore
  @ManyToMany(mappedBy = "diaries")
  private Set<User> users;

  @PreRemove
  private void removeAssociations() {
    for (User user : this.getUsers()) {
      user.getDiaries().remove(this);
    }
  }
}