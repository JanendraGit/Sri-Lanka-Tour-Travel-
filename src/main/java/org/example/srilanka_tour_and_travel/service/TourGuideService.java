package org.example.srilanka_tour_and_travel.service;

import lombok.Data;
import org.example.srilanka_tour_and_travel.controller.dto.TourGuideDTO;
import org.example.srilanka_tour_and_travel.controller.request.TourGuideRequest;
import org.example.srilanka_tour_and_travel.entity.TourGuide;
import org.example.srilanka_tour_and_travel.exception.TourGuideNotFoundException;
import org.example.srilanka_tour_and_travel.mapper.TourGuideMapper;
import org.example.srilanka_tour_and_travel.repository.TourGuideRepository;
import org.example.srilanka_tour_and_travel.service.impl.TourGuideImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class TourGuideService implements TourGuideImpl {

    private final TourGuideRepository tourGuideRepository;
    private final TourGuideMapper tourGuideMapper;
    @Override
    public TourGuideRequest addTourGuide(TourGuideRequest tourGuideRequest) {
        Optional<TourGuide> tourGuideOptional = tourGuideRepository.findByEmail(tourGuideRequest.getEmail());
        if (tourGuideOptional.isPresent()){
            throw new TourGuideNotFoundException("Tour Guide already exists with this email :"+tourGuideRequest.getEmail());
        }
        TourGuide tourGuide = tourGuideMapper.toEntity(tourGuideRequest);
        tourGuideRepository.save(tourGuide);
        return tourGuideRequest;
    }

    @Override
    public void updateTourGuide(Long id, TourGuideRequest tourGuideRequest) {
        TourGuide tourGuide = tourGuideRepository.findById(id)
                .orElseThrow(()-> new TourGuideNotFoundException("Tour Guide not found with id: "+id));
        tourGuide.setFullName(tourGuideRequest.getFullName());
        tourGuide.setEmail(tourGuideRequest.getEmail());
        tourGuide.setPhone(tourGuideRequest.getPhone());
        tourGuide.setLanguage(tourGuideRequest.getLanguage());
        tourGuide.setRating(tourGuideRequest.getRating());
        tourGuideRepository.save(tourGuide);
    }

    @Override
    public void deleteTourGuide(Long id) {
        TourGuide tourGuide = tourGuideRepository.findById(id)
                .orElseThrow(()-> new TourGuideNotFoundException("Tour Guide not found with id: "+id));
        tourGuideRepository.delete(tourGuide);
    }

    @Override
    public TourGuideDTO getTourGuideById(Long id) {
        TourGuide tourGuide = tourGuideRepository.findById(id)
                .orElseThrow(()->new TourGuideNotFoundException("Tour Guide not found with id: "+id));
        return tourGuideMapper.toDTO(tourGuide);
    }

    @Override
    public List<TourGuideDTO> getAllTourGuides() {
        List<TourGuide> tourGuides = tourGuideRepository.findAll();
        return tourGuides.stream().map(tourGuideMapper::toDTO).toList();
    }
}
