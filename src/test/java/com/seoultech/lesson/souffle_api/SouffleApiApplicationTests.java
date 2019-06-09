package com.seoultech.lesson.souffle_api;

import com.seoultech.lesson.souffle_api.dto.Reservation;
import com.seoultech.lesson.souffle_api.repository.ReservationRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SouffleApiApplicationTests {


    @Autowired
    ReservationRepository reservationRepository;

    @Test
    public void contextLoads() {
        Reservation reservation = Reservation.builder()
                .date("2019-01-01")
                .name("leejw")
                .purpose("study")
                .roomNumber(121)
                .state("reserved")
                .studentNumber(15109355)
                .timeEnd("09:00")
                .timeStart("10:00")
                .totalMember(5)
                .build();

        reservationRepository.save(reservation);

        Reservation reservation2 = Reservation.builder()
                .date("2019-01-01")
                .name("leejw")
                .purpose("study")
                .roomNumber(121)
                .state("reserved")
                .studentNumber(15109355)
                .timeEnd("09:00")
                .timeStart("10:00")
                .totalMember(5)
                .build();

        reservationRepository.save(reservation2);

        List<Reservation> list = reservationRepository.findAll();

//        Assert.assertEquals(leejw.getName(), "leejw");
    }

    @After
    public void deleteAll(){
        reservationRepository.deleteAll();
    }

}
