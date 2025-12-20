package org.example.srilanka_tour_and_travel.service;

import lombok.Data;
import org.example.srilanka_tour_and_travel.controller.dto.ReviewDTO;
import org.example.srilanka_tour_and_travel.controller.request.ReviewRequest;
import org.example.srilanka_tour_and_travel.entity.Package;
import org.example.srilanka_tour_and_travel.entity.Review;
import org.example.srilanka_tour_and_travel.entity.User;
import org.example.srilanka_tour_and_travel.exception.ReviewNotFoundException;
import org.example.srilanka_tour_and_travel.exception.UserNotFoundException;
import org.example.srilanka_tour_and_travel.mapper.ReviewMapper;
import org.example.srilanka_tour_and_travel.repository.PackageRepository;
import org.example.srilanka_tour_and_travel.repository.ReviewRepository;
import org.example.srilanka_tour_and_travel.repository.UserRepository;
import org.example.srilanka_tour_and_travel.service.impl.ReviewImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class ReviewService implements ReviewImpl {
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;
    private final UserRepository userRepository;
    private final PackageRepository packageRepository;

    @Override
    public ReviewRequest addReview(ReviewRequest reviewRequest) {
        User user = userRepository.findById(reviewRequest.getUserId())
                .orElseThrow(()->new UserNotFoundException("User not found with id: "+reviewRequest.getUserId()));
        Package package1 = packageRepository.findById(reviewRequest.getPackageId())
                .orElseThrow();
        Review review = reviewMapper.toEntity(reviewRequest);
        review.setUser(user);
        review.setTravelPackage(package1);
        reviewRepository.save(review);
        return reviewRequest;
    }

    @Override
    public void updateReview(Long id, ReviewRequest reviewRequest) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(()-> new ReviewNotFoundException("Review not found with id: "+id));
        review.setRating(reviewRequest.getRating());
        review.setComment(reviewRequest.getComment());
        review.setCreatedDate(reviewRequest.getCreatedDate());
        reviewRepository.save(review);
    }

    @Override
    public void deleteReview(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(()->new  ReviewNotFoundException("Review not found with id: "+id));
        reviewRepository.delete(review);
    }

    @Override
    public ReviewDTO getReviewById(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(()->new ReviewNotFoundException("Review not found with id: "+id));
        return reviewMapper.reviewDTO(review);
    }

    @Override
    public List<ReviewDTO> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream().map(reviewMapper::reviewDTO).toList();
    }
}
