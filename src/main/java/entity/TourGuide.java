package entity;

import jakarta.persistence.*;
import lombok.Data;

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
}
