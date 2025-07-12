package com.example.microservice.DTO.Response;

public class UserResponse {
    private String Name;
    private String Email;
    private String Password;

    public UserResponse() {}

    public UserResponse(String name, String email) {
        this.Name = name;
        this.Email = email;
    }

    public String getEmail() {
        return Email;
    }

    public String getName() {
        return Name;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public void setName(String name) {
        this.Name = name;
    }
}
