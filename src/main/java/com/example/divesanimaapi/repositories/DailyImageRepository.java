package com.example.divesanimaapi.repositories;

import com.example.divesanimaapi.models.DailyImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyImageRepository extends JpaRepository<DailyImage, Integer> {
}
