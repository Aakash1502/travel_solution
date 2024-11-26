package com.aakash.hotel_info.models;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hotel_availability")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class availability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "Date", nullable = false)
    private Date date;

    @Column(name = "availableRooms", nullable = false)
    private int rooms;

    @ManyToOne
    @JoinColumn(name = "hotel_no", nullable = false)
    private Hotels hotel;
}
