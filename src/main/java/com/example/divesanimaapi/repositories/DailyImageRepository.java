package com.example.divesanimaapi.repositories;

import com.example.divesanimaapi.models.entities.DailyImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DailyImageRepository extends JpaRepository<DailyImage, Integer> {

  @Query(nativeQuery = true, value = "select * from daily_images order by random() limit 1")
  DailyImage getRandom();
}
