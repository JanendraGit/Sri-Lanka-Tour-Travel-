package entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
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
}
