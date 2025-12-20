package org.example.srilanka_tour_and_travel.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name="admins")
public class Admin {
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

    @OneToMany(mappedBy = "admin",cascade = CascadeType.ALL)
    private List<Package> packages;

    @OneToMany(mappedBy = "admin",cascade = CascadeType.ALL)
    private List<Promotion> promotions;
}
