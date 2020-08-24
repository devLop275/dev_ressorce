package com.example.jwt.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jwt.bean.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
	
    public Optional<User> findByEmail(String email);
    
}
