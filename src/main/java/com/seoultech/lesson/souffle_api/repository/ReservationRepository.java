package com.seoultech.lesson.souffle_api.repository;

import com.seoultech.lesson.souffle_api.dto.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    public List<Reservation> findByName(String name);
    public List<Reservation> findByStudentNumber(int studentNumber);
    public List<Reservation> findByStudentNumberAndDate(int studentNumber, String date);
    public List<Reservation> findByBuilding(String building);
    public List<Reservation> findByBuildingAndRoomNumberAndDate(String building, int roomNumber, String date);
    public void deleteById(int id);
}
