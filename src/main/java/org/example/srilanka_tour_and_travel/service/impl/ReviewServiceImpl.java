package org.example.srilanka_tour_and_travel.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.srilanka_tour_and_travel.dto.ReviewDTO;
import org.example.srilanka_tour_and_travel.dto.request.ReviewRequest;
import org.example.srilanka_tour_and_travel.entity.Package;
import org.example.srilanka_tour_and_travel.entity.Review;
import org.example.srilanka_tour_and_travel.entity.User;
import org.example.srilanka_tour_and_travel.exception.ReviewNotFoundException;
import org.example.srilanka_tour_and_travel.exception.UserNotFoundException;
import org.example.srilanka_tour_and_travel.mapper.ReviewMapper;
import org.example.srilanka_tour_and_travel.repository.PackageRepository;
import org.example.srilanka_tour_and_travel.repository.ReviewRepository;
import org.example.srilanka_tour_and_travel.repository.UserRepository;
import org.example.srilanka_tour_and_travel.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;
    private final UserRepository userRepository;
    private final PackageRepository packageRepository;

    @Override
    public ReviewRequest addReview(ReviewRequest reviewRequest) {
        log.info("Creating a new review for user: {} and package: {}", reviewRequest.getUserId(), reviewRequest.getPackageId());
        User user = userRepository.findById(reviewRequest.getUserId())
                .orElseThrow(()->new UserNotFoundException("User not found with id: "+reviewRequest.getUserId()));
        Package package1 = packageRepository.findById(reviewRequest.getPackageId())
                .orElseThrow(() -> new RuntimeException("Package not found with id: " + reviewRequest.getPackageId()));
        Review review = reviewMapper.toEntity(reviewRequest);
        review.setUser(user);
        review.setTravelPackage(package1);
        reviewRepository.save(review);
        log.info("Review created successfully with id: {}", review.getReviewId());
        return reviewRequest;
    }

    @Override
    public void updateReview(Long id, ReviewRequest reviewRequest) {
        log.info("Updating review with id: {}", id);
        Review review = reviewRepository.findById(id)
                .orElseThrow(()-> new ReviewNotFoundException("Review not found with id: "+id));
        review.setRating(reviewRequest.getRating());
        review.setComment(reviewRequest.getComment());
        review.setCreatedDate(reviewRequest.getCreatedDate());
        reviewRepository.save(review);
        log.info("Review updated successfully with id: {}", review.getReviewId());
    }

    @Override
    public void deleteReview(Long id) {
        log.info("Deleting review with id: {}", id);
        Review review = reviewRepository.findById(id)
                .orElseThrow(()->new  ReviewNotFoundException("Review not found with id: "+id));
        reviewRepository.delete(review);
        log.info("Review deleted successfully with id: {}", id);
    }

    @Override
    public ReviewDTO getReviewById(Long id) {
        log.info("Fetching review by id: {}", id);
        Review review = reviewRepository.findById(id)
                .orElseThrow(()->new ReviewNotFoundException("Review not found with id: "+id));
        return reviewMapper.reviewDTO(review);
    }

    @Override
    public List<ReviewDTO> getAllReviews() {
        log.info("Fetching all reviews");
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream().map(reviewMapper::reviewDTO).toList();
    }
}
