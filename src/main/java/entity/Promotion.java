package entity;

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

    @ManyToMany(mappedBy = "promotion")
    private List<Package> packages;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;
}
