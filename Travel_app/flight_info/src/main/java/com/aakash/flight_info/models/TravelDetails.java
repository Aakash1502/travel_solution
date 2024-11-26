package com.aakash.flight_info.models;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelDetails {
    private String source;
    private String destination;
    private Date date;
}
