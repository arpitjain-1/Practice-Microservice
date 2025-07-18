package com.practice.hotel.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.hotel.Entity.Hotel;
import com.practice.hotel.Repository.HotelRepository;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public String createHotel(Hotel hotel){
        hotelRepository.save(hotel);
        return "User Created";
    }

    public Optional<Hotel> viewHotel(String id){
        Optional<Hotel> hotel = hotelRepository.findById(id);
        return hotel;
    }

    public List<Hotel> viewAllHotels(){
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels;
    }
}
