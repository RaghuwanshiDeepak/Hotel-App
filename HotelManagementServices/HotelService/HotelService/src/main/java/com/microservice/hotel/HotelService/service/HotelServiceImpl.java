package com.microservice.hotel.HotelService.service;

import com.microservice.hotel.HotelService.domain.Hotel;
import com.microservice.hotel.HotelService.exceptionHandling.ResourceNotFoundException;
import com.microservice.hotel.HotelService.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotelsDetails() {
        return (hotelRepository.findAll());
    }

    @Override
    public Hotel getHotelByHotelId(Integer hotelId) {
        return hotelRepository.findById(hotelId)
                .orElseThrow(() ->
                new ResourceNotFoundException("No Hotel present by the given id"));
    }

    @Override
    public void deleteHotel(Integer hotelId) {
         hotelRepository.deleteById(hotelId);
    }

    @Override
    public Boolean updateHotelDetails(Hotel hotel) {
        boolean isDataUpdated = false;
        Hotel updateData = hotelRepository.save(hotel);
        if (updateData.equals(hotel)){
            isDataUpdated = true;
        }
        return isDataUpdated;
    }

}
