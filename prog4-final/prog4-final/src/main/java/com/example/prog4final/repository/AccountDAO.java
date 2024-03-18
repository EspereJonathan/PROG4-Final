package com.example.prog4final.repository;

import com.example.prog4final.model.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountDAO {
    void insert(Account account);
    List<Account> findAll() throws SQLException;
    List<Account> findById(int id_account) throws SQLException;
}
