package com.abel.bank.records;

import com.abel.bank.enums.EnumAccountType;
import com.abel.bank.exceptions.BankAccountException;

public record BankAccountRecord(String name, EnumAccountType accountType, String balance) {
    public BankAccountRecord {
        if (name == null || name.isEmpty()) {
            throw new BankAccountException("field name can't be empty or null");
        }

        if (accountType == EnumAccountType.NONE) {
            throw new BankAccountException("account type must be checking or saving");
        }

        if (!balance.matches("^[0-9]+.?[0-9]+$")) {
            throw new BankAccountException("invalid value for monetary context");
        }
    }
}
