package org.example.srilanka_tour_and_travel.service.impl;

import org.example.srilanka_tour_and_travel.controller.dto.ReviewDTO;
import org.example.srilanka_tour_and_travel.controller.request.ReviewRequest;
import org.example.srilanka_tour_and_travel.controller.response.ReviewResponse;

import java.util.List;

public interface ReviewImpl {
    ReviewRequest addReview(ReviewRequest reviewRequest);
    void  updateReview(Long id,ReviewRequest reviewRequest);
    void deleteReview(Long id);
    ReviewDTO getReviewById(Long id);
    List<ReviewDTO> getAllReviews();
}
