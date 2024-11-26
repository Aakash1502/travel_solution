package com.aakash.hotel_info.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aakash.hotel_info.models.Hotels;

@Repository
public interface hotelRepo extends JpaRepository<Hotels, Long> {
    @Query(value = "SELECT h.name FROM hotels h JOIN hotel_availability a ON h.hotel_no = a.hotel_no " +
            "WHERE a.date BETWEEN :checkInDate AND :checkOutDate " +
            "AND h.place = :Destination " +
            "AND a.available_rooms >= :required " +
            "GROUP BY h.hotel_no, h.name " +
            "HAVING COUNT(a.date) = DATEDIFF(:checkOutDate, :checkInDate) + 1", nativeQuery = true)
    List<String> findHotelsWithAvailableRooms(
            @Param("checkInDate") Date checkInDate,
            @Param("checkOutDate") Date checkOutDate,
            @Param("required") int req_rooms,
            @Param("Destination") String place);

}
