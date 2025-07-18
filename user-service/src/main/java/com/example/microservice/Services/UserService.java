package com.example.microservice.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservice.DTO.Request.UserRequest;
import com.example.microservice.DTO.Response.UserResponse;
import com.example.microservice.Entities.User;
import com.example.microservice.Repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String createUser(UserRequest userPayload) {
        User user = new User();
        user.setEmail(userPayload.getEmail());
        user.setName(userPayload.getName());
        user.setPassword(userPayload.getPassword());
        userRepository.save(user);
        return "User Created";
    }

    public String greetUser(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
        return "Welcome " + user.getName();
    }

    public String deleteUser(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
        userRepository.deleteById(id);
        return user.getName()+" Deleted";
    }

    public UserResponse updateUser(String id, UserRequest userUpdatePayload) {
        UserResponse userResponse = new UserResponse();
    
        Optional<User> exUser = userRepository.findById(id);
        if (exUser.isPresent()) {
            User user = exUser.get();
            if (userUpdatePayload.getName() != null) user.setName(userUpdatePayload.getName());
            if (userUpdatePayload.getEmail() != null) user.setEmail(userUpdatePayload.getEmail());
            if (userUpdatePayload.getPassword() != null) user.setPassword(userUpdatePayload.getPassword());
            userRepository.save(user);
            userResponse.setEmail(user.getEmail());
            userResponse.setName(user.getName());
        }
        return userResponse;
    }
}
