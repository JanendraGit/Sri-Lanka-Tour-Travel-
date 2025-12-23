package org.example.srilanka_tour_and_travel.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    Long userId;
    String fullName;
    String email;
    String phone;
    String role;
    String country;
    LocalDate dateJoined;
}
