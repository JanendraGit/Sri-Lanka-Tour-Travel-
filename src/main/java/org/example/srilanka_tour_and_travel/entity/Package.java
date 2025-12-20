package org.example.srilanka_tour_and_travel.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "packages")
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long packageId;
    private String packageName;
    private String packageDescription;
    private String packageImage;
    private String packageCategory;
    private String price;
    private String availability;
    private Integer duration;


    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Destination destination;

    @OneToMany(mappedBy = "travelPackage",cascade = CascadeType.ALL)
    private List<Review> reviewList;

    @ManyToMany
    @JoinTable(
            name="package_promotion",
            joinColumns=@JoinColumn(name="package_id"),
            inverseJoinColumns=@JoinColumn(name="promo_id")
    )
    List<Promotion> promotions;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @ManyToOne
    @JoinColumn(name = "tourgu_id")
    private TourGuide  tourGuide;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
