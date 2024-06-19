package com.microservice.hotel.HotelService.domain;

import com.microservice.hotel.HotelService.utils.RoomType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hotelId;

    private String  name;

    private String  location;

    private String  about;

    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    @Email(message = "Email cannot be null")
    @NotNull
    private String contactEmail;

    private Long contactNumber;

}
