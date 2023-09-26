package com.example.divesanimaapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "diaries")
public class Diary {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "date", nullable = false)
  private LocalDate date;

  @Column(name = "record", nullable = false)
  private String record;

  @Column(name = "completed", nullable = false)
  private Boolean completed = false;

  @ManyToMany(mappedBy = "diaries")
  private Set<User> users;
}