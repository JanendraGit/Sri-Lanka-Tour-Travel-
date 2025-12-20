package org.example.srilanka_tour_and_travel.repository;

import org.example.srilanka_tour_and_travel.entity.TourGuide;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TourGuideRepository extends JpaRepository<TourGuide,Long> {
    Optional<TourGuide> findByEmail(String email);
}
