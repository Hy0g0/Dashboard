package com.example.application.data.service;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.application.data.entity.User;

public interface UserRepository extends JpaRepository<User, UUID> {

    User findByUsername(String username);
}