package com.example.divesanimaapi.models.dto.requests.todo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeTodoRequest {

  private Integer id;
  private String record;
}
