package com.microservice.rating.Rating.services;

import com.microservice.rating.Rating.domain.Rating;

import java.util.List;

public interface RatingService {

    Rating createRating(Rating rating);

    List<Rating> getFullRating();

    Rating getRatingByUserId(Long userId);

    Rating getRatingByHotelId(Long hotelId);
}
