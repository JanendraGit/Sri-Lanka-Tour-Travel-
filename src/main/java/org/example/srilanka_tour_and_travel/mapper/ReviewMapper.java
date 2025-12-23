package org.example.srilanka_tour_and_travel.mapper;

import org.example.srilanka_tour_and_travel.dto.ReviewDTO;
import org.example.srilanka_tour_and_travel.dto.request.ReviewRequest;
import org.example.srilanka_tour_and_travel.entity.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {
    public Review toEntity(ReviewRequest request){
        Review review = new Review();
        review.setRating(request.getRating());
        review.setComment(request.getComment());
        review.setCreatedDate(java.time.LocalDate.now());
        return review;
    }
    public ReviewDTO reviewDTO(Review review){
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setReviewId(review.getReviewId());
        reviewDTO.setRating(review.getRating());
        reviewDTO.setComment(review.getComment());
        reviewDTO.setCreatedDate(review.getCreatedDate());
        return reviewDTO;
    }
}
