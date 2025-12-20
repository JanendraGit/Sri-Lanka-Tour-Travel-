package org.example.srilanka_tour_and_travel.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

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

    @ManyToMany
    @JoinTable(
            name = "booking_package",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "package_id")
    )
    private List<Package> packageList;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

}
