package com.example.microservice.Controllers;

import com.example.microservice.DTO.Request.UserRequest;
import com.example.microservice.DTO.Response.UserResponse;
import com.example.microservice.Entities.User;
import com.example.microservice.Services.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<String> helloUser(@PathVariable String id) {
        return ResponseEntity.ok(userService.greetUser(id));
    }

    @GetMapping("/user/{id}")
    @Retry(name = "userServiceRetry", fallbackMethod = "handleRetryFallback")
    // @CircuitBreaker(name = "userServiceCB", fallbackMethod = "userEntityFallback")
    public ResponseEntity<Optional<User>> getUserEntity(@PathVariable String id) {
        return ResponseEntity.ok(userService.getUserEntity(id));
    }

    public ResponseEntity<Optional<User>> handleRetryFallback(String id, Throwable t) {
    logger.warn("Retry fallback triggered: {}", t.toString());
    User dummyUser = new User();
    dummyUser.setName("Fallback User");
    return ResponseEntity.ok(Optional.of(dummyUser));
}

    // public ResponseEntity<Optional<User>> userEntityFallback(String id, Throwable ex) {
    //     logger.warn("Circuit Breaker fallback triggered for getUserEntity(), userId: {}. Reason: {}", id, ex.toString());
    //     User fallbackUser = new User();
    //     fallbackUser.setName("Unknown");
    //     fallbackUser.setEmail("unknown@email.com");
    //     fallbackUser.setRatings(List.of());
    //     return ResponseEntity.ok(Optional.of(fallbackUser));
    // }

    @PostMapping("/new")
    public ResponseEntity<User> createUser(@RequestBody UserRequest userPayload) {
        return ResponseEntity.ok(userService.createUser(userPayload));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable String id,
            @RequestBody UserRequest userUpdatePayload) {
        return ResponseEntity.ok(userService.updateUser(id, userUpdatePayload));
    }
}