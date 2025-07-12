package com.example.microservice.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microservice.Entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    
}
