package org.example.srilanka_tour_and_travel.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    LocalDate bookingDate;
    String status;           // (PENDING, CONFIRMED, CANCELED)
    Integer travelersCount;
    Double totalAmount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "package_id")
    private Package package_;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

}
