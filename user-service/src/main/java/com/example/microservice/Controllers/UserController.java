package com.example.microservice.Controllers;

import com.example.microservice.DTO.Request.UserRequest;
import com.example.microservice.DTO.Response.UserResponse;
import com.example.microservice.Entities.User;
import com.example.microservice.Services.UserService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<String> helloUser(@PathVariable String id) {
        return ResponseEntity.ok(userService.greetUser(id));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Optional<User>> getUserEntity(@PathVariable String id) {
        return ResponseEntity.ok(userService.getUserEntity(id));
    }

    @PostMapping("/new")
    public ResponseEntity<User> createUser(@RequestBody UserRequest userPayload){
        return ResponseEntity.ok(userService.createUser(userPayload));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id){
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable String id, @RequestBody UserRequest userUpdatePayload) {
        return ResponseEntity.ok(userService.updateUser(id, userUpdatePayload));
    } 
}