package org.example.srilanka_tour_and_travel.mapper;

import org.example.srilanka_tour_and_travel.dto.TourGuideDTO;
import org.example.srilanka_tour_and_travel.dto.request.TourGuideRequest;
import org.example.srilanka_tour_and_travel.entity.TourGuide;
import org.springframework.stereotype.Component;

@Component
public class TourGuideMapper {
    public TourGuide toEntity(TourGuideRequest request){
        TourGuide tourGuide = new TourGuide();
        tourGuide.setFullName(request.getFullName());
        tourGuide.setEmail(request.getEmail());
        tourGuide.setPhone(request.getPhone());
        tourGuide.setLanguage(request.getLanguage());
        tourGuide.setRating(request.getRating());
        return tourGuide;
    }

    public TourGuideDTO toDTO(TourGuide tourGuide){
        TourGuideDTO tourGuideDTO = new TourGuideDTO();
        tourGuideDTO.setGuideId(tourGuide.getGuideId());
        tourGuideDTO.setFullName(tourGuide.getFullName());
        tourGuideDTO.setEmail(tourGuide.getEmail());
        tourGuideDTO.setPhone(tourGuide.getPhone());
        tourGuideDTO.setLanguage(tourGuide.getLanguage());
        tourGuideDTO.setRating(tourGuide.getRating());
        return tourGuideDTO;
    }
}
