package com.seoultech.lesson.souffle_api.controller;

import com.seoultech.lesson.souffle_api.dto.DefaultResponseDto;
import com.seoultech.lesson.souffle_api.dto.Reservation;
import com.seoultech.lesson.souffle_api.dto.ReservationRequestDto;
import com.seoultech.lesson.souffle_api.repository.ReservationRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/reserve")
@RestController
@Api(tags = "Reservation", description = "예약")
public class ReservationController {

    @Autowired
    ReservationRepository reservationRepository;

    @PostMapping("")
    @ResponseBody
    @ApiOperation(value = "예약하기")
    public ResponseEntity<?> createReservation(@Valid @RequestBody ReservationRequestDto requestDto) {

        Reservation reservation = Reservation.builder()
                .roomNumber(requestDto.getRoom_number())
                .date(requestDto.getDate())
                .studentNumber(requestDto.getStudent_number())
                .purpose(requestDto.getPurpose())
                .totalMember(requestDto.getTotal_member())
                .timeStart(requestDto.getTime_start())
                .timeEnd(requestDto.getTime_end())
                .building(requestDto.getBuilding())
                .name(requestDto.getName())
                .build();
        reservationRepository.save(reservation);

        return new ResponseEntity<>(new DefaultResponseDto(true), HttpStatus.CREATED);
    }

    @GetMapping("/stnumber")
    @ResponseBody
    @ApiOperation(value = "예약확인 (By StNumber)", notes = "학번으로 예약목록을 받습니다")
    public ResponseEntity<?> readReservationByStudentNumber(int student_number) {
        return new ResponseEntity<>(reservationRepository.findByStudentNumber(student_number), HttpStatus.OK);
    }

    @GetMapping("/stnumber_date")
    @ResponseBody
    @ApiOperation(value = "예약확인 (By StNumber, Date)", notes = "학번, 날짜로 예약목록을 받습니다")
    public ResponseEntity<?> readReservationByStudentNumberAndDate(int studentNumber, String date) {
        return new ResponseEntity<>(reservationRepository.findByStudentNumberAndDate(studentNumber, date), HttpStatus.OK);
    }

    @GetMapping("/building")
    @ResponseBody
    @ApiOperation(value = "예약확인 (By Building)", notes = "건물명으로 예약목록을 받습니다")
    public ResponseEntity<?> readReservationByBuilding(String building) {

        return new ResponseEntity<>(reservationRepository.findByBuilding(building), HttpStatus.OK);
    }

    @GetMapping("/building_roomnum_date")
    @ResponseBody
    @ApiOperation(value = "예약확인 (By Building, RoomNumber, Date", notes = "건물명, 강의실 번호, 날짜로 예약목록을 받습니다")
    public ResponseEntity<?> readReservationByBuildingAndRoomNumberAndDate(String building, int roomNumber, String date) {
        return new ResponseEntity<>(reservationRepository.findByBuildingAndRoomNumberAndDate(building, roomNumber, date), HttpStatus.OK);
    }

    @GetMapping("")
    @ResponseBody
    @ApiOperation(value = "예약확인")
    public ResponseEntity<?> readReservation() {

        return new ResponseEntity<>(reservationRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping("")
    @ResponseBody
    @ApiOperation(value = "예약수정")
    public ResponseEntity<?> updateReservation(@Valid @RequestBody Reservation reservation) {

        reservationRepository.save(reservation);

        return new ResponseEntity<>(new DefaultResponseDto(true), HttpStatus.OK);
    }

    @DeleteMapping("")
    @ResponseBody
    @ApiOperation(value = "예약취소")
    public ResponseEntity<?> deleteReservation(@Valid @RequestBody Long id) {

        reservationRepository.deleteById(id);

        return new ResponseEntity<>(new DefaultResponseDto(true), HttpStatus.OK);
    }
}
