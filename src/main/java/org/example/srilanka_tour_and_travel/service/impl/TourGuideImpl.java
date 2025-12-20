package org.example.srilanka_tour_and_travel.service.impl;

import org.example.srilanka_tour_and_travel.controller.dto.TourGuideDTO;
import org.example.srilanka_tour_and_travel.controller.request.TourGuideRequest;
import org.example.srilanka_tour_and_travel.entity.TourGuide;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TourGuideImpl{
    TourGuideRequest addTourGuide(TourGuideRequest tourGuideRequest);
    void updateTourGuide(Long id,TourGuideRequest tourGuideRequest);
    void deleteTourGuide(Long id);
    TourGuideDTO getTourGuideById(Long id);
    List<TourGuideDTO> getAllTourGuides();
}
