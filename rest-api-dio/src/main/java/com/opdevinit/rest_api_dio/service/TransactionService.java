package com.opdevinit.rest_api_dio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opdevinit.rest_api_dio.DTO.TransactionDTO;
import com.opdevinit.rest_api_dio.model.Account;
import com.opdevinit.rest_api_dio.model.Transaction;
import com.opdevinit.rest_api_dio.repository.AccountRepository;
import com.opdevinit.rest_api_dio.repository.TransactionRepository;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    AccountRepository accountRepository;

    public Account findByAccount(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }

    public Account createNewTransaction(TransactionDTO transaction) {
        Account src = accountRepository.findByAccountNumber(transaction.getAccountNumber());

        if (src == null) {
            System.out.println("User not exist, Try again");
        }

        Transaction instanceOf = new Transaction( transaction.getAmount(), LocalDateTime.now());

        src.getTransactions().add(instanceOf);
        src.setBalance(src.getBalance().add(transaction.getAmount()));

        transactionRepository.save(instanceOf);

        return src ;
    }
}
