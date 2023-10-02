package com.example.divesanimaapi.models.dto.requests.todo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTodoRequest {

  @JsonProperty("user_id")
  private Integer userId;
  private String record;
}
