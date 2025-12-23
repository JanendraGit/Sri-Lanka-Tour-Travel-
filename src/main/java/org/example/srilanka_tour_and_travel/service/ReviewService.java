package org.example.srilanka_tour_and_travel.service;

import org.example.srilanka_tour_and_travel.dto.ReviewDTO;
import org.example.srilanka_tour_and_travel.dto.request.ReviewRequest;

import java.util.List;

public interface ReviewService {
    ReviewRequest addReview(ReviewRequest reviewRequest);
    void  updateReview(Long id,ReviewRequest reviewRequest);
    void deleteReview(Long id);
    ReviewDTO getReviewById(Long id);
    List<ReviewDTO> getAllReviews();
}
