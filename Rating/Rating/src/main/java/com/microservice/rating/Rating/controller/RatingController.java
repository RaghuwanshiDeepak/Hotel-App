package com.microservice.rating.Rating.controller;

import com.microservice.rating.Rating.domain.Rating;
import com.microservice.rating.Rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/save-rating")
    private ResponseEntity<Rating> createRating(@RequestBody Rating hotelRating) {
        ResponseEntity<Rating> response;
        if (Objects.nonNull(hotelRating)) {
            Rating savedRating = ratingService.createRating(hotelRating);
            response = ResponseEntity.status(HttpStatus.CREATED).body(savedRating);
        } else {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return response;
    }


    @GetMapping("/getAllHotelsRatings")
    private ResponseEntity<List<Rating>> getAllHotelsRating() {
        ResponseEntity<List<Rating>> response;
        List<Rating> allHotelsRating = ratingService.getFullRating();
        if (Objects.nonNull(allHotelsRating) && !allHotelsRating.isEmpty()) {
            response = ResponseEntity.status(HttpStatus.OK).body(allHotelsRating);
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }
        return response;
    }

    @GetMapping("/getRatingByUserId/{userId}")
    private ResponseEntity<Rating> getRatingByUserId(@PathVariable Long userId) {
        ResponseEntity<Rating> response;
        Rating hotelrating = Objects.nonNull(userId) ? ratingService.getRatingByUserId(userId) : null;
        if (Objects.nonNull(hotelrating)) {
            response = ResponseEntity.status(HttpStatus.OK).body(hotelrating);
        } else {
            response = ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
        }
        return response;
    }

    @GetMapping("/getRatingByHotelId/{hotelId}")
    private ResponseEntity<Rating> getRatingByHotelId(@PathVariable Long hotelId) {
        ResponseEntity<Rating> response;
        Rating hotelrating = Objects.nonNull(hotelId) ? ratingService.getRatingByHotelId(hotelId) : null;
        if (Objects.nonNull(hotelrating)) {
            response = ResponseEntity.status(HttpStatus.OK).body(hotelrating);
        } else {
            response = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(null);
        }
        return response;
    }
}
