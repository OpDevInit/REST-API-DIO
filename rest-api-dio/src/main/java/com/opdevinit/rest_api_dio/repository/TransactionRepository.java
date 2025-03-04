package com.opdevinit.rest_api_dio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.opdevinit.rest_api_dio.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    
}
