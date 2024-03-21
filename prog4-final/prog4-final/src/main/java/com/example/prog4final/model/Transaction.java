package com.example.prog4final.model;

import lombok.*;

import java.security.Timestamp;

@ToString
@AllArgsConstructor
public class Transaction {
    private int id_transaction;
    private java.sql.Timestamp dateTransaction;
    private double amount;
    private String type;
    private String reason;
    private Account account;



    public int getId_transaction() {
        return id_transaction;
    }

    public void setId_transaction(int id_transaction) {
        this.id_transaction = id_transaction;
    }

    public java.sql.Timestamp getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(java.sql.Timestamp dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getType() {
        return type;
    }
}
