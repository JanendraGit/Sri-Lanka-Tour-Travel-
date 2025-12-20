package org.example.srilanka_tour_and_travel.controller.dto;

import lombok.Data;

import java.util.List;

@Data
public class PackageDTO {
    private Long packageId;
    private String packageName;
    private String packageDescription;
    private String packageImage;
    private String packageCategory;
    private String price;
    private String availability;
    private Integer duration;

    private String destinationName;
    private String adminName;
    private String tourGuideName;
    private String hotelName;

    private List<String> promotions;
}
