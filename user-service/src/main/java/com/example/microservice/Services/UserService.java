package com.example.microservice.Services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.HttpClientErrorException;

import com.example.microservice.DTO.Request.UserRequest;
import com.example.microservice.DTO.Response.Rating;
import com.example.microservice.DTO.Response.UserResponse;
import com.example.microservice.Entities.User;
import com.example.microservice.Repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;
    
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public User createUser(UserRequest userPayload) {
        User user = new User();
        user.setEmail(userPayload.getEmail());
        user.setName(userPayload.getName());
        user.setPassword(userPayload.getPassword());
        userRepository.save(user);
        return user;
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
        return user.getName() + " Deleted";
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

    public Optional<User> getUserEntity(String id) {
        Optional<User> userOpt = userRepository.findById(id);
        
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            
            try {
                Rating[] ratingsArray = restTemplate.getForObject(
                    "http://localhost:8083/ratings/user/" + id, 
                    Rating[].class
                );
                
                if (ratingsArray != null) {
                    user.setRatings(Arrays.asList(ratingsArray));
                    logger.info("Successfully fetched {} ratings for user: {}", ratingsArray.length, id);
                } else {
                    user.setRatings(new ArrayList<>());
                    logger.warn("No ratings found for user: {}", id);
                }
                
            } catch (ResourceAccessException e) {
                logger.error("Rating service is not accessible for user: {}", id, e);
                user.setRatings(new ArrayList<>());
            } catch (HttpClientErrorException e) {
                logger.error("HTTP error when fetching ratings for user: {} - Status: {}", id, e.getStatusCode());
                user.setRatings(new ArrayList<>());
            } catch (Exception e) {
                logger.error("Unexpected error fetching ratings for user: {}", id, e);
                user.setRatings(new ArrayList<>());
            }
            
        } else {
            logger.warn("User not found with ID: {}", id);
        }
        
        return userOpt;
    }
}