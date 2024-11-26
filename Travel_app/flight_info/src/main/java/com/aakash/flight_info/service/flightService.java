package com.aakash.flight_info.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.aakash.flight_info.dto.FlightsDto;
import com.aakash.flight_info.models.Flights;
import com.aakash.flight_info.models.TravelDetails;
import com.aakash.flight_info.repository.flightRepo;

public class flightService {

    @Autowired
    flightRepo fr;

    public ResponseEntity<List<FlightsDto>> getFlights(TravelDetails td) {
        List<Flights> li = fr.findByTravelDetails(td.getSource(), td.getDestination(), td.getDate());
        List<FlightsDto> fdto = new ArrayList<>();

        for (Flights f : li) {
            FlightsDto fldto = new FlightsDto(f.getSource(), f.getDestination(), f.getDate(), f.getSeats());
            fdto.add(fldto);
        }
        return new ResponseEntity<>(fdto, HttpStatus.OK);
    }

    public ResponseEntity<String> book_flight(Flights f, int seat) {
        int avail_seats = fr.findSeats(f.getFlight_no(), f.getSource(), f.getDestination(), f.getDate(), f.getSeats());
        if (avail_seats > seat) {
            fr.updateSeats(f.getFlight_no(), f.getSource(), f.getDestination(), f.getDate(), 1);
            return new ResponseEntity<>("Flight Successfully Booked", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Flight is full", HttpStatus.OK);
        }
    }
}
