package com.example.divesanimaapi.dto.requests.diary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeDiaryRequest {

  private Integer id;
  private String record;
  private LocalDate date;
}
