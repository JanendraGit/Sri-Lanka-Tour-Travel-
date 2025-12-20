package org.example.srilanka_tour_and_travel.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long paymentId;
    LocalDate paymentDate;
    Double amount;
    String method;           // (CARD, PAYPAL, STRIPE, LOCAL)
    String status;           // (SUCCESS, FAILED, REFUNDED)

    @OneToOne
    @JoinColumn(name = "booking_id",referencedColumnName = "bookingId")
    private Booking booking;
}
