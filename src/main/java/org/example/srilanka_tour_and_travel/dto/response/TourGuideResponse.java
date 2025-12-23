package org.example.srilanka_tour_and_travel.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TourGuideResponse {
    private Long guideId;
    private String fullName;
    private String email;
    private String phone;
    private String language;
    private Double rating;
}
