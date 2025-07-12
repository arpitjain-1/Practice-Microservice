package com.example.microservice.Controllers;

import com.example.microservice.DTO.Request.UserRequest;
import com.example.microservice.DTO.Response.UserResponse;
import com.example.microservice.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public ResponseEntity<String> helloUser(@PathVariable int id) {
        return ResponseEntity.ok(userService.greetUser(id));
    }

    @PostMapping("/new")
    public ResponseEntity<String> createUser(@RequestBody UserRequest userPayload){
        return ResponseEntity.ok(userService.createUser(userPayload));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable String id, @RequestBody UserRequest userUpdatePayload) {
        return ResponseEntity.ok(userService.updateUser(id, userUpdatePayload));
    }
}
