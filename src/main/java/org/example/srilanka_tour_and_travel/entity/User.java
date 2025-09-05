package org.example.srilanka_tour_and_travel.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userId;
    String fullName;
    String email;
    String password;
    String phone;
    String role;        // (ADMIN, TOURIST, GUIDE, MANAGER)
    String country;
    LocalDate dateJoined;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Booking> bookings;

    @OneToMany(mappedBy = "review",cascade = CascadeType.ALL)
    private List<Review> reviews;
}
