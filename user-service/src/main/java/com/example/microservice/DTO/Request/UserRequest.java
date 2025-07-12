package com.example.microservice.DTO.Request;

import java.util.List;

public class UserRequest {
    private String Name;
    private String Email;
    private String Password;

    public UserRequest() {}

    public UserRequest(String name, String email, String password) {
        this.Name = name;
        this.Email = email;
        this.Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public String getName() {
        return Name;
    }

    public String getPassword() {
        return Password;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setPassword(String password) {
        this.Password = password;
    }
}
