package org.example.srilanka_tour_and_travel.controller.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TourGuideRequest {
    Long guideId;
    String fullName;
    String email;
    String phone;
    String language;        // (English, Sinhala, Tamil, French, etc.)
    Double rating;
}
