package com.example.divesanimaapi.dto.requests.todo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeTodoRecordRequest {

  private Integer id;
  private String record;
}
