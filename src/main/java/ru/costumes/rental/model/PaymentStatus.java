package ru.costumes.rental.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "payment_status")
public class PaymentStatus {

    @Id
    @ManyToOne
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;

    @Id
    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;
}
