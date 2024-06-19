package com.microservice.rating.Rating.repository;

import com.microservice.rating.Rating.domain.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating,Long> {
}
