package org.example.srilanka_tour_and_travel.dto;

import lombok.Data;

@Data
public class TourGuideDTO {
    Long guideId;
    String fullName;
    String email;
    String phone;
    String language;        // (English, Sinhala, Tamil, French, etc.)
    Double rating;
}
