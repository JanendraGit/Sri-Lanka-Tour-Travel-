package org.example.srilanka_tour_and_travel.service;

import org.example.srilanka_tour_and_travel.dto.HotelDTO;

import java.util.List;

public interface HotelService {
    HotelDTO createHotel(HotelDTO hotelDTO);
    HotelDTO getHotelById(Long id);
    List<HotelDTO> getAllHotels();
    HotelDTO updateHotel(Long id, HotelDTO hotelDTO);
    void deleteHotel(Long id);
}
