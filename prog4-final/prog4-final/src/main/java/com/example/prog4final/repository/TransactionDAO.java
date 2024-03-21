package com.example.prog4final.repository;

import com.example.prog4final.model.Account;
import com.example.prog4final.model.Transaction;

import java.sql.SQLException;
import java.util.List;

public interface TransactionDAO {
    void insert(Transaction transaction);

    List<Transaction> findAll()throws SQLException;
    List<Transaction> findByIdAccount(Account account) throws SQLException;
}
