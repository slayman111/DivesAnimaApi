package com.example.divesanimaapi.dto.requests.todo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTodoRecordRequest {

  @JsonProperty("user_id")
  private Integer userId;
  private String record;
}
