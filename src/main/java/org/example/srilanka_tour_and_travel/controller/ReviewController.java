package org.example.srilanka_tour_and_travel.controller;

import lombok.RequiredArgsConstructor;
import org.example.srilanka_tour_and_travel.dto.ReviewDTO;
import org.example.srilanka_tour_and_travel.dto.request.ReviewRequest;
import org.example.srilanka_tour_and_travel.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewRequest> addReview(@RequestBody ReviewRequest reviewRequest){
        ReviewRequest savedReview = reviewService.addReview(reviewRequest);
        return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateReview(@PathVariable Long id, @RequestBody ReviewRequest reviewRequest){
        reviewService.updateReview(id, reviewRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id){
        reviewService.deleteReview(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDTO> getReviewById(@PathVariable Long id){
        ReviewDTO reviewDTO = reviewService.getReviewById(id);
        return new ResponseEntity<>(reviewDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ReviewDTO>> getAllReviews(){
        List<ReviewDTO> reviews = reviewService.getAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }
}
