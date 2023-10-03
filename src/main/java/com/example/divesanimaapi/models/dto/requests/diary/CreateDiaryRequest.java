package com.example.divesanimaapi.models.dto.requests.diary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateDiaryRequest {

  private String record;
  private LocalDate date;
}
