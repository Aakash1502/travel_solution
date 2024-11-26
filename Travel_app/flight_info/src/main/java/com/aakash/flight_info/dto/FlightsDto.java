package com.aakash.flight_info.dto;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightsDto {
    private String source;
    private String destination;
    private Date date;
    private int seats;
}
