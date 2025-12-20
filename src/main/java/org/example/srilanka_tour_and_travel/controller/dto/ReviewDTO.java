package org.example.srilanka_tour_and_travel.controller.dto;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReviewDTO {
    private Long reviewId;
    private Integer rating;
    private String comment;
    private LocalDate createdDate;
    private Long userId;
    private Long packageId;
}
