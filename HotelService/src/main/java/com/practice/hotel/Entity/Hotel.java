package com.practice.hotel.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection="hotels")
public class Hotel {
    @Id
    private String id;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("location")
    private String location;
    
    @JsonProperty("about")
    private String about;

    public Hotel(){} // Default constructor

    public Hotel(String name, String location, String about){
        this.name = name;
        this.location = location;
        this.about = about;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", about='" + about + '\'' +
                '}';
    }
}