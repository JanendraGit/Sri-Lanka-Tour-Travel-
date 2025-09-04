package entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    LocalDate bookingDate;
    String status;           // (PENDING, CONFIRMED, CANCELED)
    Integer travelersCount;
    Double totalAmount;
}
