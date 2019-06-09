package com.seoultech.lesson.souffle_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Data
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequestDto {

    @JsonProperty("roomNumber")
    private Integer room_number;

    @NotBlank
    @JsonProperty("date")
    private String date;

    @JsonProperty("studentNumber")
    private int student_number;

    @NotBlank
    @JsonProperty("purpose")
    private String purpose;

    @JsonProperty("totalMember")
    private int total_member;

    @NotBlank
    @JsonProperty("timeStart")
    private String time_start;

    @NotBlank
    @JsonProperty("timeEnd")
    private String time_end;

    @NotBlank
    @JsonProperty("building")
    private String building;

    @NotBlank
    @JsonProperty("name")
    private String name;


}
