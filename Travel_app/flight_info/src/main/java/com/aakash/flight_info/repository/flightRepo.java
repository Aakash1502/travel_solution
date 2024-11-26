package com.aakash.flight_info.repository;

import org.springframework.stereotype.Repository;
import com.aakash.flight_info.models.Flights;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface flightRepo extends JpaRepository<Flights, Long> {

    @Query(value = "SELECT * FROM flights f WHERE f.source=:src AND f.destination=:dest AND f.date=:date", nativeQuery = true)
    List<Flights> findByTravelDetails(String src, String dest, Date date);

    @Query(value = "SELECT seats FROM flights f WHERE f.flight_no=:fno AND f.source=:src AND f.destination=:dest AND f.date=:date And f.seats>=seat", nativeQuery = true)
    int findSeats(Long fno, String src, String dest, Date date, int seat);

    @Query(value = "UPDATE flights SET seats=seats-seat WHERE flight_no=:fno AND source=:src AND destination=:dest AND date=:d")
    void updateSeats(Long fno, String src, String dest, Date d, int seat);
}
