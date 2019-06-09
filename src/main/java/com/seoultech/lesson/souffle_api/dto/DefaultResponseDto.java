package com.seoultech.lesson.souffle_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DefaultResponseDto {

    @JsonProperty("success")
    private Boolean success = false;
}
