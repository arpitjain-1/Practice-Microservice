package com.example.microservice.Entities;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="hotels")
public class Hotel {
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("location")
    private String location;
    
    @JsonProperty("about")
    private String about;

    @Id
    private String hotelId;

    public Hotel(){} // Default constructor

    public Hotel(String name, String location, String about){
        this.name = name;
        this.location = location;
        this.about = about;
    }

    @PrePersist
    public void generateId() {
        this.hotelId = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId='" + hotelId + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", about='" + about + '\'' +
                '}';
    }
}
