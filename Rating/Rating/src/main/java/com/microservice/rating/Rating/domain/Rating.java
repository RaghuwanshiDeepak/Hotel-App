package com.microservice.rating.Rating.domain;

import com.microservice.rating.Rating.utils.Stars;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@Entity
@Builder
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ratingId;

    private Long userId;

    private Integer hotelId;

    private String feedback;

    @Enumerated(EnumType.STRING)
    private Stars stars;
}
