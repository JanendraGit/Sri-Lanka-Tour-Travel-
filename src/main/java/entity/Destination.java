package entity;

import jakarta.persistence.*;
import lombok.Data;

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
}
