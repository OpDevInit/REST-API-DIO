package com.opdevinit.rest_api_dio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.opdevinit.rest_api_dio.DTO.TransactionDTO;
import com.opdevinit.rest_api_dio.model.Account;
import com.opdevinit.rest_api_dio.model.Transaction;
import com.opdevinit.rest_api_dio.service.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/{accountNumber}")
    public Account getAllTransactions(@PathVariable String accountNumber) {
        return transactionService.findByAccount(accountNumber);
    }

    @PostMapping
    public ResponseEntity<Account> createTransaction(@RequestBody TransactionDTO transaction) {
        return ResponseEntity.ok(transactionService.createNewTransaction(transaction));
    }
}
