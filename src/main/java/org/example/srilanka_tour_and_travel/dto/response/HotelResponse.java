package org.example.srilanka_tour_and_travel.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HotelResponse {
    private Long hotelId;
    private String name;
    private String location;
    private String description;
    private Double pricePerNight;
    private String imageUrl;
    private String contactNumber;
}
