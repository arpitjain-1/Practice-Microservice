package com.example.microservice.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.microservice.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByEmail(String email);
    
}
