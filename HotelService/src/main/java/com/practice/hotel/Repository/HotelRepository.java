package com.practice.hotel.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.practice.hotel.Entity.Hotel;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String>{
    
}
