package com.example.prog4final.service;

import com.example.prog4final.model.Account;
import com.example.prog4final.repository.AccountImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class AccountService {
    @Autowired
    private AccountImplementation accountImplementation;

    public List<Account> findAllAccount() throws SQLException {
        return accountImplementation.findAll();
    }
    public List<Account> findIdAccount() throws SQLException {
        return accountImplementation.findID();
    }

}
