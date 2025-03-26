package com.abel.bank.core;

import com.abel.bank.exceptions.BankAccountException;
import com.abel.bank.records.BankAccountRecord;

import java.math.BigDecimal;

public interface BankInterface {
    void newBankAccount(BankAccountRecord clientData) throws BankAccountException;
    void deposit(
            final String owner,
            final BigDecimal valueBalance
    ) throws BankAccountException;
    void withdraw(
            final String owner,
            final BigDecimal valueBalance
    ) throws BankAccountException;
    void transfer(
            final String senderName,
            final String receiverName,
            final BigDecimal valueBalance
    );
    void queryBalance(String owner) throws BankAccountException;
    void deleteAccount(String owner) throws BankAccountException;
}
