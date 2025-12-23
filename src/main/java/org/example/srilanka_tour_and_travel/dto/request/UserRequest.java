package org.example.srilanka_tour_and_travel.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    Long userId;
    String fullName;
    String email;
    String password;
    String phone;
    String role;
    String country;
    LocalDate dateJoined;
}
