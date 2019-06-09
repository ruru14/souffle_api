package com.seoultech.lesson.souffle_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@ToString
@Getter
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("roomNumber")
    @Column(name = "roomNumber")
    private int roomNumber;

    @NotBlank
    @JsonProperty("date")
    private String date;

    @JsonProperty("studentNumber")
    @Column(name = "student_number")
    private int studentNumber;

    @NotBlank
    @JsonProperty("purpose")
    private String purpose;

    @JsonProperty("totalMember")
    @Column(name = "totalMember")
    private int totalMember;

    @NotBlank
    @JsonProperty("timeStart")
    @Column(name = "timeStart")
    private String timeStart;

    @NotBlank
    @JsonProperty("timeEnd")
    @Column(name = "timeEnd")
    private String timeEnd;

    @NotBlank
    @JsonProperty("building")
    private String building;

    @NotBlank
    @JsonProperty("name")
    private String name;

    @Builder
    public Reservation(int roomNumber, String date, int studentNumber, String purpose, int totalMember, String timeStart, String timeEnd, String building, String name){
        this.roomNumber = roomNumber;
        this.date = date;
        this.studentNumber = studentNumber;
        this.purpose = purpose;
        this.totalMember = totalMember;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.building = building;
        this.name = name;
    }

    @Builder
    public Reservation(Long id, int roomNumber, String date, int studentNumber, String purpose, int totalMember, String timeStart, String timeEnd, String building, String name){
        this.id = id;
        this.roomNumber = roomNumber;
        this.date = date;
        this.studentNumber = studentNumber;
        this.purpose = purpose;
        this.totalMember = totalMember;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.building = building;
        this.name = name;
    }
}
