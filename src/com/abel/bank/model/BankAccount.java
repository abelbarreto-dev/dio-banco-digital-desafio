package com.abel.bank.model;

import com.abel.bank.enums.EnumAccountType;

import java.math.BigDecimal;
import java.util.Objects;

public class BankAccount {
    private String name;
    private EnumAccountType accountType;
    private BigDecimal balance;

    public BankAccount() {
        this.name = "client";
        this.accountType = EnumAccountType.NONE;
        this.balance = new BigDecimal("0.00");
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BankAccount that)) return false;
        return Objects.equals(name, that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getName());
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "name='" + name + '\'' +
                ", accountType=" + accountType +
                ", balance=" + balance +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnumAccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(EnumAccountType accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
