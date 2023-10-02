package com.example.divesanimaapi.repositories;

import com.example.divesanimaapi.models.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

  List<Todo> findTodosByUsersId(Integer userId);
}
