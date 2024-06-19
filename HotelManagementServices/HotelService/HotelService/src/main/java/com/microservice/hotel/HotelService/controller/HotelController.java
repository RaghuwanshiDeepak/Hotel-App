package com.microservice.hotel.HotelService.controller;

import com.microservice.hotel.HotelService.domain.Hotel;
import com.microservice.hotel.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/save-hotel")
    private ResponseEntity<Hotel> createHotel(@Valid @RequestBody Hotel hotel) {
        ResponseEntity<Hotel> response;
        if (Objects.nonNull(hotel)) {
            Hotel savedHotel = hotelService.createHotel(hotel);
            response = ResponseEntity.status(HttpStatus.CREATED).body(savedHotel);
        } else {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return response;
    }

    @GetMapping("/getAllHotels")
    private ResponseEntity<List<Hotel>> getAllHotels() {
        ResponseEntity<List<Hotel>> response;
        List<Hotel> allHotelsDetails = hotelService.getAllHotelsDetails();
        if (Objects.nonNull(allHotelsDetails) && !allHotelsDetails.isEmpty()) {
            response = ResponseEntity.status(HttpStatus.OK).body(allHotelsDetails);
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }
        return response;
    }

    @PutMapping("/updateHotel")
    private ResponseEntity<Boolean> updateHotelDetails(@Valid @RequestBody Hotel hotel){
        ResponseEntity<Boolean> response;
        Boolean isDataSaved = false;
        if(Objects.nonNull(hotel)){
            isDataSaved = hotelService.updateHotelDetails(hotel);
            response = ResponseEntity.status(HttpStatus.ACCEPTED).body(isDataSaved);
        }else {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(isDataSaved);
        }
        return response;
    }

    @DeleteMapping("deleteHotel/{hotelId}")
    private ResponseEntity<String> deleteHotelByHotelId(@PathVariable Integer hotelId) {
        ResponseEntity<String> response;
        if (Objects.nonNull(hotelId)) {
            hotelService.deleteHotel(hotelId);
            response = ResponseEntity.status(HttpStatus.ACCEPTED).
                    body("Hotel deleted on the given hotel id");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("There is no such hotel present with the given hotel id");
        }
        return response;
    }

    @GetMapping("/getById/{hotelId}")
    private ResponseEntity<Hotel> getHotelWithHotelId(@PathVariable Integer hotelId) {
        ResponseEntity<Hotel> response;
        Hotel hotel = Objects.nonNull(hotelId) ? hotelService.getHotelByHotelId(hotelId) : null;
        if (Objects.nonNull(hotel)) {
            response = ResponseEntity.status(HttpStatus.OK).body(hotel);
        } else {
            response = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(null);
        }
        return response;
    }
}
