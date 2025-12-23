package org.example.srilanka_tour_and_travel.mapper;

import org.example.srilanka_tour_and_travel.dto.HotelDTO;
import org.example.srilanka_tour_and_travel.dto.request.HotelRequest;
import org.example.srilanka_tour_and_travel.dto.response.HotelResponse;
import org.example.srilanka_tour_and_travel.entity.Hotel;
import org.springframework.stereotype.Component;

@Component
public class HotelMapper {

    public HotelDTO toDto(Hotel hotel) {
        if (hotel == null) {
            return null;
        }
        return new HotelDTO(
                hotel.getHotelId(),
                hotel.getName(),
                hotel.getLocation(),
                hotel.getDescription(),
                hotel.getPricePerNight(),
                hotel.getImageUrl(),
                hotel.getContactNumber()
        );
    }

    public Hotel toEntity(HotelDTO hotelDTO) {
        if (hotelDTO == null) {
            return null;
        }
        Hotel hotel = new Hotel();
        hotel.setHotelId(hotelDTO.getHotelId());
        hotel.setName(hotelDTO.getName());
        hotel.setLocation(hotelDTO.getLocation());
        hotel.setDescription(hotelDTO.getDescription());
        hotel.setPricePerNight(hotelDTO.getPricePerNight());
        hotel.setImageUrl(hotelDTO.getImageUrl());
        hotel.setContactNumber(hotelDTO.getContactNumber());
        return hotel;
    }
    
    public HotelResponse toResponse(HotelDTO hotelDTO) {
        if (hotelDTO == null) {
            return null;
        }
        return new HotelResponse(
                hotelDTO.getHotelId(),
                hotelDTO.getName(),
                hotelDTO.getLocation(),
                hotelDTO.getDescription(),
                hotelDTO.getPricePerNight(),
                hotelDTO.getImageUrl(),
                hotelDTO.getContactNumber()
        );
    }

    public HotelDTO requestToDto(HotelRequest hotelRequest) {
        if (hotelRequest == null) {
            return null;
        }
        HotelDTO hotelDTO = new HotelDTO();
        hotelDTO.setName(hotelRequest.getName());
        hotelDTO.setLocation(hotelRequest.getLocation());
        hotelDTO.setDescription(hotelRequest.getDescription());
        hotelDTO.setPricePerNight(hotelRequest.getPricePerNight());
        hotelDTO.setImageUrl(hotelRequest.getImageUrl());
        hotelDTO.setContactNumber(hotelRequest.getContactNumber());
        return hotelDTO;
    }
}
