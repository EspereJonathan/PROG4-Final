package com.example.prog4final.repository;

import com.example.prog4final.model.Account;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class AccountImplementation implements AccountDAO {
    private Connection connection;

    public AccountImplementation(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Account account) {

    }

    @Override
    public List<Account> findAll() throws SQLException {
        List<Account> allAccount = new ArrayList<>();
        String sql ="SELECT * FROM account";
        try(PreparedStatement preparedStatement= connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                allAccount.add(new Account(
                        resultSet.getInt("id_account"),
                        resultSet.getString("lastName"),
                        resultSet.getString("firstName"),
                        resultSet.getDate("birthDate"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("accountNumber")

                ));
            }
        }
        return allAccount;
    }



    @Override
    public List<Account> findById(int id_account) {
        List<Account> oneAccount=new ArrayList<>();
        String sql="SELECT * FROM account WHERE id_account= ? ";
        try (PreparedStatement preparedStatement= connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id_account);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                oneAccount.add(new Account(
                        resultSet.getInt("id_account"),
                        resultSet.getString("lastName"),
                        resultSet.getString("firstName"),
                        resultSet.getDate("birthDate"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("accountNumber")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    return oneAccount;
    }

}
