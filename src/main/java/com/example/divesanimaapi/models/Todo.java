package com.example.divesanimaapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "todos")
public class Todo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "record", nullable = false)
  private String records;

  @Column(name = "completed", nullable = false)
  private Boolean completed;

  @JsonIgnore
  @ManyToMany(mappedBy = "todos")
  private Set<User> users;
}