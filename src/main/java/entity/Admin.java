package entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name="admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userId;
    String fullName;
    String email;
    String password;
    String phone;
    String role;        // (ADMIN, TOURIST, GUIDE, MANAGER)
    String country;
    LocalDate dateJoined;
}
