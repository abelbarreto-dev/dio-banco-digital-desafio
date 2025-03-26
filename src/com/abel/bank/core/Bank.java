package com.abel.bank.core;

import com.abel.bank.exceptions.BankAccountException;
import com.abel.bank.model.BankAccount;
import com.abel.bank.records.BankAccountRecord;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Bank implements BankInterface {
    private final Set<BankAccount> bankAccounts;

    public Bank() {
        this.bankAccounts = new HashSet<>();
    }

    protected Set<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    @Override
    public void newBankAccount(BankAccountRecord clientData) throws BankAccountException {
        System.out.println("create new bank account".toUpperCase());

        final var newBankAccount = new BankAccount();
        newBankAccount.setName(clientData.name());
        newBankAccount.setAccountType(clientData.accountType());
        newBankAccount.setBalance(new BigDecimal(clientData.balance()));

        if (this.getBankAccounts().contains(newBankAccount)) {
            throw new BankAccountException("this account already exists");
        }

        this.getBankAccounts().add(newBankAccount);
        System.out.println("bank account created with success.");
    }

    @Override
    public void deposit(final String owner, final BigDecimal valueBalance)
    throws BankAccountException {
        System.out.println("making a deposit".toUpperCase());

        var valueZero = new BigDecimal("0.0");

        if (valueBalance.compareTo(valueZero) < 0)
            throw new BankAccountException("negative value not allowed.");

        BankAccount account = this.getBankAccounts().stream().filter(
        bankAccount -> owner.equals(bankAccount.getName())
        ).findFirst().orElse(null);

        if (account == null)
            throw new BankAccountException("account not found.");

        account.setBalance(account.getBalance().add(valueBalance));

        System.out.println("deposit was made with success");
    }

    @Override
    public void withdraw(String owner, BigDecimal valueBalance)
    throws BankAccountException {
        System.out.println("making an withdraw".toUpperCase());

        var valueZero = new BigDecimal("0.0");

        if (valueBalance.compareTo(valueZero) < 0)
            throw new BankAccountException("negative value not allowed.");

        BankAccount account = this.getBankAccounts().stream().filter(
        bankAccount -> owner.equals(bankAccount.getName())
        ).findFirst().orElse(null);

        if (account == null)
            throw new BankAccountException("account not found.");

        if (account.getBalance().compareTo(valueBalance) < 0)
            throw new BankAccountException("account balance insufficient.");

        account.setBalance(account.getBalance().subtract(valueBalance));

        System.out.println("withdraw was made with success");
    }

    @Override
    public void transfer(String senderName, String receiverName, BigDecimal valueBalance)
    throws BankAccountException {
        System.out.println("transfer money between accounts".toUpperCase());

        var valueZero = new BigDecimal("0.0");

        if (valueBalance.compareTo(valueZero) < 0)
            throw new BankAccountException("negative value not allowed.");

        BankAccount sender = this.getBankAccounts().stream().filter(
        bankAccount -> senderName.equals(bankAccount.getName())
        ).findFirst().orElse(null);

        if (sender == null)
            throw new BankAccountException("sender account not found.");

        if (sender.getBalance().compareTo(valueBalance) < 0)
            throw new BankAccountException("sender balance insufficient.");

        BankAccount receiver = this.getBankAccounts().stream().filter(
        bankAccount -> receiverName.equals(bankAccount.getName())
        ).findFirst().orElse(null);

        if (receiver == null)
            throw new BankAccountException("receiver account not found.");

        sender.setBalance(sender.getBalance().subtract(valueBalance));
        receiver.setBalance(receiver.getBalance().add(valueBalance));

        System.out.println("transfer was made with success.");
    }

    @Override
    public void queryBalance(String owner) throws BankAccountException {
        System.out.println("querying the balance of account".toUpperCase());

        BankAccount account = this.getBankAccounts().stream().filter(
        bankAccount -> owner.equals(bankAccount.getName())
        ).findFirst().orElse(null);

        if (account == null)
            throw new BankAccountException("account not found.");

        System.out.println(account);
    }

    @Override
    public void deleteAccount(String owner) throws BankAccountException {
        System.out.println("deleting existing bank account".toUpperCase());

        BankAccount account = this.getBankAccounts().stream().filter(
        bankAccount -> owner.equals(bankAccount.getName())
        ).findFirst().orElse(null);

        if (account == null)
            throw new BankAccountException("account not found to delete.");

        this.getBankAccounts().remove(account);
        System.out.println("bank account '" + owner + "' successfully deleted.");
    }
}
