package com.aakash.hotel_info.serivce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aakash.hotel_info.models.TravelDetails;
import com.aakash.hotel_info.repo.hotelRepo;

@Service
public class hotelService {

    @Autowired
    hotelRepo hr;

    public ResponseEntity<List<String>> getHotels(TravelDetails td) {
        List<String> li = hr.findHotelsWithAvailableRooms(td.getCheckin_date(), td.getCheckout_date(), td.getRooms(),
                td.getPlace());
        return new ResponseEntity<>(li, HttpStatus.OK);
    }
}
