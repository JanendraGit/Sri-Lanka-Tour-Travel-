package org.example.srilanka_tour_and_travel.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "tourguides")
public class TourGuide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long guideId;
    String fullName;
    String email;
    String phone;
    String language;        // (English, Sinhala, Tamil, French, etc.)
    Double rating;          // average rating

    @OneToMany(mappedBy = "tourGuide",cascade = CascadeType.ALL)
    private List<Package> packages;
}
