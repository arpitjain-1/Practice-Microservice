package com.practice.RatingService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.RatingService.Entity.Rating;
import com.practice.RatingService.Repository.RatingRepository;

@Service
public class RatingService {
    
    @Autowired
    private RatingRepository ratingRepository;

    public String createRating(Rating rating) {
        ratingRepository.save(rating);
        return "Rating created";
    }

    public List<Rating> getRatingsByUserId(String userId){
        return ratingRepository.findByUserId(userId);
    }

    public List<Rating> getRatingsByHotelId(String hotelId){
        return ratingRepository.findByHotelId(hotelId);
    }
}
