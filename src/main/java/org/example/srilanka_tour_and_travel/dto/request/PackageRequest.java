package org.example.srilanka_tour_and_travel.dto.request;

import lombok.Data;

@Data
public class PackageRequest {
    private String packageName;
    private String packageDescription;
    private String packageImage;
    private String packageCategory;
    private String price;
    private String availability;
    private Integer duration;

    private Long destinationId;
    private Long adminId;
    private Long tourGuideId;
    private Long hotelId;
}
