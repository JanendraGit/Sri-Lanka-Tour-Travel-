package org.example.srilanka_tour_and_travel.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.srilanka_tour_and_travel.dto.TourGuideDTO;
import org.example.srilanka_tour_and_travel.dto.request.TourGuideRequest;
import org.example.srilanka_tour_and_travel.entity.TourGuide;
import org.example.srilanka_tour_and_travel.exception.TourGuideNotFoundException;
import org.example.srilanka_tour_and_travel.mapper.TourGuideMapper;
import org.example.srilanka_tour_and_travel.repository.TourGuideRepository;
import org.example.srilanka_tour_and_travel.service.TourGuideService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TourGuideServiceImpl implements TourGuideService {

    private final TourGuideRepository tourGuideRepository;
    private final TourGuideMapper tourGuideMapper;
    @Override
    public TourGuideRequest addTourGuide(TourGuideRequest tourGuideRequest) {
        log.info("Creating a new tour guide: {}", tourGuideRequest.getFullName());
        Optional<TourGuide> tourGuideOptional = tourGuideRepository.findByEmail(tourGuideRequest.getEmail());
        if (tourGuideOptional.isPresent()){
            throw new RuntimeException("Tour Guide already exists with this email :"+tourGuideRequest.getEmail());
        }
        TourGuide tourGuide = tourGuideMapper.toEntity(tourGuideRequest);
        tourGuideRepository.save(tourGuide);
        log.info("Tour guide created successfully with id: {}", tourGuide.getGuideId());
        return tourGuideRequest;
    }

    @Override
    public void updateTourGuide(Long id, TourGuideRequest tourGuideRequest) {
        log.info("Updating tour guide with id: {}", id);
        TourGuide tourGuide = tourGuideRepository.findById(id)
                .orElseThrow(()-> new TourGuideNotFoundException("Tour Guide not found with id: "+id));
        tourGuide.setFullName(tourGuideRequest.getFullName());
        tourGuide.setEmail(tourGuideRequest.getEmail());
        tourGuide.setPhone(tourGuideRequest.getPhone());
        tourGuide.setLanguage(tourGuideRequest.getLanguage());
        tourGuide.setRating(tourGuideRequest.getRating());
        tourGuideRepository.save(tourGuide);
        log.info("Tour guide updated successfully with id: {}", tourGuide.getGuideId());
    }

    @Override
    public void deleteTourGuide(Long id) {
        log.info("Deleting tour guide with id: {}", id);
        TourGuide tourGuide = tourGuideRepository.findById(id)
                .orElseThrow(()-> new TourGuideNotFoundException("Tour Guide not found with id: "+id));
        tourGuideRepository.delete(tourGuide);
        log.info("Tour guide deleted successfully with id: {}", id);
    }

    @Override
    public TourGuideDTO getTourGuideById(Long id) {
        log.info("Fetching tour guide by id: {}", id);
        TourGuide tourGuide = tourGuideRepository.findById(id)
                .orElseThrow(()->new TourGuideNotFoundException("Tour Guide not found with id: "+id));
        return tourGuideMapper.toDTO(tourGuide);
    }

    @Override
    public List<TourGuideDTO> getAllTourGuides() {
        log.info("Fetching all tour guides");
        List<TourGuide> tourGuides = tourGuideRepository.findAll();
        return tourGuides.stream().map(tourGuideMapper::toDTO).toList();
    }
}
