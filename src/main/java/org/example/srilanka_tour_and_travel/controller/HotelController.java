package org.example.srilanka_tour_and_travel.controller;

import lombok.RequiredArgsConstructor;
import org.example.srilanka_tour_and_travel.dto.HotelDTO;
import org.example.srilanka_tour_and_travel.dto.request.HotelRequest;
import org.example.srilanka_tour_and_travel.dto.response.HotelResponse;
import org.example.srilanka_tour_and_travel.mapper.HotelMapper;
import org.example.srilanka_tour_and_travel.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/hotels")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;
    private final HotelMapper hotelMapper;

    @PostMapping
    public ResponseEntity<HotelResponse> createHotel(@RequestBody HotelRequest hotelRequest) {
        HotelDTO hotelDTO = hotelMapper.requestToDto(hotelRequest);
        HotelDTO createdHotel = hotelService.createHotel(hotelDTO);
        HotelResponse response = hotelMapper.toResponse(createdHotel);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelResponse> getHotelById(@PathVariable Long id) {
        HotelDTO hotelDTO = hotelService.getHotelById(id);
        HotelResponse response = hotelMapper.toResponse(hotelDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<HotelResponse>> getAllHotels() {
        List<HotelDTO> hotels = hotelService.getAllHotels();
        List<HotelResponse> response = hotels.stream()
                .map(hotelMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HotelResponse> updateHotel(@PathVariable Long id, @RequestBody HotelRequest hotelRequest) {
        HotelDTO hotelDTO = hotelMapper.requestToDto(hotelRequest);
        HotelDTO updatedHotel = hotelService.updateHotel(id, hotelDTO);
        HotelResponse response = hotelMapper.toResponse(updatedHotel);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
        return ResponseEntity.noContent().build();
    }
}
