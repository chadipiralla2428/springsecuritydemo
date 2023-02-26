package com.example.securitydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.securitydemo.entity.User;

public interface userRepo extends JpaRepository<User, Integer> {
	User findByUsername(String username);

}
