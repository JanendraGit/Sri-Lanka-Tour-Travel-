package org.example.srilanka_tour_and_travel.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {
    Long userId;
    String fullName;
    String email;
    String phone;
    String role;
    String country;
    LocalDate dateJoined;
}
