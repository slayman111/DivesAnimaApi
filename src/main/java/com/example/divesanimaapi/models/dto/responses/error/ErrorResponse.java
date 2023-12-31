package com.example.divesanimaapi.models.dto.responses.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

  @JsonProperty("status_code")
  private Integer statusCode;
  private String error;
}
