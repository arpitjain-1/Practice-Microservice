package com.example.microservice.Services;

import com.example.microservice.DTO.Request.UserRequest;
import com.example.microservice.DTO.Response.UserResponse;
import com.example.microservice.Entities.User;

public class UserService {

    public String createUser(UserRequest userPayload) {
        return "User Created";
    }

    public String greetUser(int id) {
        return "User Updated";
    }

    public String deleteUser(int id) {
        return "User Deleted";
    }

    public UserResponse updateUser(String id, UserRequest userUpdatePayload) {
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }
}
