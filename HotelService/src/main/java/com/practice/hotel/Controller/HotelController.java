package com.practice.hotel.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.hotel.Entity.Hotel;
import com.practice.hotel.Service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping("/all")
    public List<Hotel> viewAllHotels(){
        return hotelService.viewAllHotels();
    }

    @GetMapping("/{id}")
    public Optional<Hotel> viewHotel(@PathVariable String id){
        return hotelService.viewHotel(id);
    }

    @PostMapping("/create")
    public String createHotel(@RequestBody Hotel hotel){
        return hotelService.createHotel(hotel);
    }
}
