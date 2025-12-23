package org.example.srilanka_tour_and_travel.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.srilanka_tour_and_travel.dto.HotelDTO;
import org.example.srilanka_tour_and_travel.entity.Hotel;
import org.example.srilanka_tour_and_travel.exception.HotelNotFoundException;
import org.example.srilanka_tour_and_travel.mapper.HotelMapper;
import org.example.srilanka_tour_and_travel.repository.HotelRepository;
import org.example.srilanka_tour_and_travel.service.HotelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;

    @Override
    public HotelDTO createHotel(HotelDTO hotelDTO) {
        log.info("Creating a new hotel: {}", hotelDTO.getName());
        Hotel hotel = hotelMapper.toEntity(hotelDTO);
        hotel = hotelRepository.save(hotel);
        log.info("Hotel created successfully with id: {}", hotel.getHotelId());
        return hotelMapper.toDto(hotel);
    }

    @Override
    public HotelDTO getHotelById(Long id) {
        log.info("Fetching hotel by id: {}", id);
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException("Hotel not found with id: " + id));
        return hotelMapper.toDto(hotel);
    }

    @Override
    public List<HotelDTO> getAllHotels() {
        log.info("Fetching all hotels");
        return hotelRepository.findAll().stream()
                .map(hotelMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public HotelDTO updateHotel(Long id, HotelDTO hotelDTO) {
        log.info("Updating hotel with id: {}", id);
        Hotel existingHotel = hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException("Hotel not found with id: " + id));

        existingHotel.setName(hotelDTO.getName());
        existingHotel.setLocation(hotelDTO.getLocation());
        existingHotel.setDescription(hotelDTO.getDescription());
        existingHotel.setPricePerNight(hotelDTO.getPricePerNight());
        existingHotel.setImageUrl(hotelDTO.getImageUrl());
        existingHotel.setContactNumber(hotelDTO.getContactNumber());

        existingHotel = hotelRepository.save(existingHotel);
        log.info("Hotel updated successfully with id: {}", existingHotel.getHotelId());
        return hotelMapper.toDto(existingHotel);
    }

    @Override
    public void deleteHotel(Long id) {
        log.info("Deleting hotel with id: {}", id);
        if (!hotelRepository.existsById(id)) {
            throw new HotelNotFoundException("Hotel not found with id: " + id);
        }
        hotelRepository.deleteById(id);
        log.info("Hotel deleted successfully with id: {}", id);
    }
}
