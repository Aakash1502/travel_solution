package com.aakash.hotel_info.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aakash.hotel_info.models.TravelDetails;
import com.aakash.hotel_info.serivce.hotelService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("hotels")
public class hotelController {

    @Autowired
    hotelService hs;

    @GetMapping("view_hotels")
    public ResponseEntity<List<String>> getHotels(@RequestBody TravelDetails td) {
        return hs.getHotels(td);
    }

    // @PostMapping("book_hotel")
    // public ResponseEntity<String> bookHotels(@RequestBody Hotels hd) {
    // return hs.book_hotel(Hd, 1);
    // }

}
