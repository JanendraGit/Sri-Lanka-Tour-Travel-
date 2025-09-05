package org.example.srilanka_tour_and_travel.repository;

import org.example.srilanka_tour_and_travel.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Integer> {
}
