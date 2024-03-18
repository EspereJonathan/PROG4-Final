package com.example.prog4final.controller;

import com.example.prog4final.model.Account;
import com.example.prog4final.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/allAccount")
    public List<Account> findAllAccount()throws SQLException{
        return accountService.findAllAccount();
    }
    @GetMapping("/account/{idAccount}")
    public List<Account> findOneAccount(@PathVariable int idAccount ) throws SQLException {
        return  accountService.findOneAccount(idAccount);
    }
}
