package org.example.srilanka_tour_and_travel.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "promotions")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long promoId;
    String code;             // e.g., "SUMMER25"
    Double discount;         // percentage (e.g., 0.25 = 25%)
    LocalDate validFrom;
    LocalDate validUntil;
    Boolean active;

    @ManyToMany
    @JoinTable(name = "package_promotion",
            joinColumns = @JoinColumn(name = "promo_id"),
            inverseJoinColumns = @JoinColumn(name = "package_id"))
    List<Package> packages;


    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;
}
