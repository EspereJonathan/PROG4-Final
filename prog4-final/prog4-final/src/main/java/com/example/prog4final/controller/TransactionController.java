package com.example.prog4final.controller;

import com.example.prog4final.model.Transaction;
import com.example.prog4final.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;
@RestController
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @GetMapping("/allTransaction")
    public List<Transaction> findAllTransaction() throws SQLException{
       return transactionService.findAllTransaction();
   }
}
