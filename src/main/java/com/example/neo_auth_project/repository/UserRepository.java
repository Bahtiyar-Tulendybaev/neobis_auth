package com.example.neo_auth_project.repository;


import com.example.neo_auth_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByName(String email);
}
