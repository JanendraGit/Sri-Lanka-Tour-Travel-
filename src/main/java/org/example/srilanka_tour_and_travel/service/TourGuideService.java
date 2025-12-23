package org.example.srilanka_tour_and_travel.service;

import org.example.srilanka_tour_and_travel.dto.TourGuideDTO;
import org.example.srilanka_tour_and_travel.dto.request.TourGuideRequest;

import java.util.List;

public interface TourGuideService {
    TourGuideRequest addTourGuide(TourGuideRequest tourGuideRequest);
    void updateTourGuide(Long id,TourGuideRequest tourGuideRequest);
    void deleteTourGuide(Long id);
    TourGuideDTO getTourGuideById(Long id);
    List<TourGuideDTO> getAllTourGuides();
}
