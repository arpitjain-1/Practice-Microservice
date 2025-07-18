package com.practice.RatingService.Entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "ratings")
public class Rating {

    @Id
    private String ratingId;

    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;

    public Rating() {
    }

    public Rating(String feedback, String userId, String hotelId, int rating) {
        this.feedback = feedback;
        this.userId = userId;
        this.hotelId = hotelId;
        this.rating = rating;
    }

    @PrePersist
    public void generateId() {
        this.ratingId = UUID.randomUUID().toString();
    }

    public String getRatingId() {
        return ratingId;
    }

    public void setRatingId(String ratingId) {
        this.ratingId = ratingId;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
