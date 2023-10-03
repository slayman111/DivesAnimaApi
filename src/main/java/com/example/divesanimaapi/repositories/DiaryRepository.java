package com.example.divesanimaapi.repositories;

import com.example.divesanimaapi.models.entities.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Integer> {

  List<Diary> findByDateBetweenAndUsersLogin(LocalDate from, LocalDate to, String login);
}
