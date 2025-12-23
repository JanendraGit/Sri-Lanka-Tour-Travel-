package org.example.srilanka_tour_and_travel.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PackageResponse {
    private Long packageId;
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
