package com.microservice.rating.Rating.services;

import com.microservice.rating.Rating.domain.Rating;
import com.microservice.rating.Rating.exception.ResourceNotFoundException;
import com.microservice.rating.Rating.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getFullRating() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating getRatingByUserId(Long userId) {
        return ratingRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("No Data Found for the given user id"));
    }

    @Override
    public Rating getRatingByHotelId(Long hotelId) {
        return ratingRepository.findById(hotelId).orElseThrow(() ->
                new ResourceNotFoundException("No rating found with the given hotel id !!!!"));
    }
}
