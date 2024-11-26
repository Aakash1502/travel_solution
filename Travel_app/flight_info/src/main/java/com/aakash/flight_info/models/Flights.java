package com.aakash.flight_info.models;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "flights")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flights {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_no")
    private Long flight_no;

    @Column(name = "Source", nullable = false)
    private String source;

    @Column(name = "Destination", nullable = false)
    private String destination;

    @Column(name = "Date", nullable = false)
    private Date date;

    @Column(name = "Seats", nullable = false)
    private int seats;

}
