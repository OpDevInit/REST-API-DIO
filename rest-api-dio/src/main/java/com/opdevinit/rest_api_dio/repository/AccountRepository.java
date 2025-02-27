package com.opdevinit.rest_api_dio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.opdevinit.rest_api_dio.model.User;

public interface AccountRepository extends JpaRepository<User, Long> {
 
    
} 
