package com.example.prog4final.service;

import com.example.prog4final.model.Transaction;
import com.example.prog4final.repository.TransactionImplementation;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class TransactionService {
    private TransactionImplementation transactionImplementation;

    public TransactionService(TransactionImplementation transactionImplementation) {
        this.transactionImplementation = transactionImplementation;
    }

    public List<Transaction> findAllTransaction()throws SQLException{
        return transactionImplementation.findAll();
    }
}
