package com.example.microservice.Services;

import com.example.microservice.Entities.User;
import com.example.microservice.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.microservice.DTO.Request.UserRequest;
import com.example.microservice.DTO.Response.UserResponse;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    public String createUser(UserRequest userPayload) {
        return "User Created";
    }

    public String greetUser(int id) {
        return "Hello ";
    }

    public String deleteUser(int id) {
        return "User Deleted";
    }

    public UserResponse updateUser(String id, UserRequest userUpdatePayload) {
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }
}
