package org.example.srilanka_tour_and_travel.controller.response;

import lombok.Data;

@Data
public class TourGuideResponse {
    Long guideId;
    String fullName;
    String email;
    String phone;
    String language;        // (English, Sinhala, Tamil, French, etc.)
    Double rating;
}
