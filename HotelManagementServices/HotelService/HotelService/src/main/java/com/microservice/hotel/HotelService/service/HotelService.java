package com.microservice.hotel.HotelService.service;

import com.microservice.hotel.HotelService.domain.Hotel;

import java.util.List;

public interface HotelService {

    Hotel createHotel(Hotel hotel);

    List<Hotel> getAllHotelsDetails();

    Hotel getHotelByHotelId(Integer hotelId);

    void deleteHotel(Integer hotelId);

    Boolean updateHotelDetails(Hotel hotel);
}
