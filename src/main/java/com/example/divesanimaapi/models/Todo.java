package com.example.divesanimaapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "todos")
public class Todo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "record", nullable = false)
  private String record;

  @Column(name = "completed", nullable = false)
  private Boolean completed;

  @JsonIgnore
  @ManyToMany(mappedBy = "todos")
  private Set<User> users;

  @PreRemove
  private void removeAssociations() {
    for (User user : this.getUsers()) {
      user.getTodos().remove(this);
    }
  }
}