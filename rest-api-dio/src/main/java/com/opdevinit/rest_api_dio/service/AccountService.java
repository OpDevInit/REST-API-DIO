package com.opdevinit.rest_api_dio.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opdevinit.rest_api_dio.model.Account;
import com.opdevinit.rest_api_dio.repository.AccountRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private  AccountRepository accountRepository;

    public Optional<Account> findById(Long id) {
        return accountRepository.findById(id);
    }

    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }
    
}
