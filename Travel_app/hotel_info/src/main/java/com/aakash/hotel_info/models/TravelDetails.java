package com.aakash.hotel_info.models;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelDetails {
    private String place;
    private Date checkin_date;
    private Date checkout_date;
    private int rooms;
}
