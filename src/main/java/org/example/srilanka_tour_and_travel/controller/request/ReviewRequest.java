package org.example.srilanka_tour_and_travel.controller.request;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ReviewRequest {
    private Integer rating;
    private String comment;
    private LocalDate createdDate;
    private Long userId;
    private Long packageId;
}
