package com.practice.RatingService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.RatingService.Entity.Rating;
import com.practice.RatingService.Service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/create")
    public ResponseEntity<String> createRating(@RequestBody Rating rating) {
        return ResponseEntity.ok(ratingService.createRating(rating));
    }

    @GetMapping("/hotel/{id}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String id) {
        return ResponseEntity.ok(ratingService.getRatingsByHotelId(id));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String id) {
        return ResponseEntity.ok(ratingService.getRatingsByUserId(id));
    }
}

