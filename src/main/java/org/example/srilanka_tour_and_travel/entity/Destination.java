package org.example.srilanka_tour_and_travel.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "destinations")
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long destinationId;
    private String destinationName;
    private String destinationLocation;
    private String description;
    private String imageUrl;
    private Double category;

    @OneToMany(mappedBy = "package",cascade = CascadeType.ALL)
    private List<Package> packages;
}
