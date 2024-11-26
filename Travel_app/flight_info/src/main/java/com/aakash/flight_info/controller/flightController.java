package com.aakash.flight_info.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aakash.flight_info.dto.FlightsDto;
import com.aakash.flight_info.models.Flights;
import com.aakash.flight_info.models.TravelDetails;
import com.aakash.flight_info.service.flightService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("flight")
public class flightController {

    @Autowired
    flightService fs;

    @GetMapping("view_flights")
    public ResponseEntity<List<FlightsDto>> getFlights(@RequestBody TravelDetails td) {
        return fs.getFlights(td);
    }

    @PostMapping("book_flight")
    public ResponseEntity<String> bookFlights(@RequestBody Flights fd) {
        return fs.book_flight(fd, 1);
    }

}
