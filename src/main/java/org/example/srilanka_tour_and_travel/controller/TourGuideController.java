package org.example.srilanka_tour_and_travel.controller;

import lombok.Data;
import org.example.srilanka_tour_and_travel.controller.dto.TourGuideDTO;
import org.example.srilanka_tour_and_travel.controller.request.TourGuideRequest;
import org.example.srilanka_tour_and_travel.service.TourGuideService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tour-guides")
@Data
public class TourGuideController {
    private final TourGuideService tourGuideService;

    @PostMapping
    public ResponseEntity<TourGuideRequest> addTourGuide(@RequestBody TourGuideRequest tourGuideRequest){
        TourGuideRequest tourGuideRequest1 = tourGuideService.addTourGuide(tourGuideRequest);
        return new ResponseEntity<>(tourGuideRequest1, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTourGuide(@PathVariable Long id, @RequestBody TourGuideRequest tourGuideRequest){
        tourGuideService.updateTourGuide(id, tourGuideRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTourGuide(@PathVariable Long id){
        tourGuideService.deleteTourGuide(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TourGuideDTO> getTourGuideById(@PathVariable Long id){
        TourGuideDTO tourGuide = tourGuideService.getTourGuideById(id);
        return new ResponseEntity<>(tourGuide, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TourGuideDTO>> getAllTourGuides(){
        List<TourGuideDTO> tourGuideDTOS = tourGuideService.getAllTourGuides();
        return new ResponseEntity<>(tourGuideDTOS, HttpStatus.OK);
    }

}
