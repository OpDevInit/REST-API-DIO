package com.opdevinit.rest_api_dio.DTO;

import java.math.BigDecimal;
import java.util.Objects;

public class TransactionDTO {
    private String accountNumber;

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    private BigDecimal amount;

    public TransactionDTO(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
