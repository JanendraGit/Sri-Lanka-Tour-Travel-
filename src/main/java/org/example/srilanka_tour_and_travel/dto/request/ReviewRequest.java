package org.example.srilanka_tour_and_travel.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequest {
    private Integer rating;
    private String comment;
    private LocalDate createdDate;
    private Long userId;
    private Long packageId;
}
