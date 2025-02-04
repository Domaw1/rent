package ru.costumes.rental.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "booking_status")
public class BookingStatus {

    @Id
    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @Id
    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;
}
