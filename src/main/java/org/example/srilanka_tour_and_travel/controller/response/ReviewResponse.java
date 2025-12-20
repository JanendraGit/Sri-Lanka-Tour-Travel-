package org.example.srilanka_tour_and_travel.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReviewResponse {
    private Long reviewId;
    private Integer rating;
    private String comment;
    private LocalDate createdDate;
    private String username;
    private String packageName;
}
