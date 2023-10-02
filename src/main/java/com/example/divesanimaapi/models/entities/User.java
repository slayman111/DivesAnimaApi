package com.example.divesanimaapi.models.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "login", nullable = false)
  private String login;

  @Column(name = "password", nullable = false)
  private String password;

  @ManyToOne
  @JoinColumn(name = "role_id")
  private Role role;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
    name = "users_diaries",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "diary_id")
  )
  private Set<Diary> diaries;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
    name = "users_todos",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "todo_id")
  )
  private Set<Todo> todos;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
    name = "users_articles",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "article_id")
  )
  private Set<Article> articles;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role.getValue()));
  }

  @Override
  public String getUsername() {
    return login;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}