package entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long hotelId;
    String name;
    String location;
    String description;
    Double pricePerNight;
    String imageUrl;
    String contactNumber;

    @OneToMany(mappedBy = "package",cascade = CascadeType.ALL)
    private List<Package> packages;
}
