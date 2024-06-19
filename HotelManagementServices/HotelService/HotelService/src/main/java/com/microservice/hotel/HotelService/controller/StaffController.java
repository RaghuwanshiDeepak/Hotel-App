package com.microservice.hotel.HotelService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {


    @GetMapping("/getAllStaff")
    private ResponseEntity<List<String>> getStaff() {
        List<String> staffList = Arrays.asList("Sachin", "Ronit", "Mukesh");
        return new ResponseEntity<>(staffList, HttpStatus.OK);
    }
}
