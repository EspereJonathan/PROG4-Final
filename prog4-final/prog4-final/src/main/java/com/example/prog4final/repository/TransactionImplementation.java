package com.example.prog4final.repository;

import com.example.prog4final.model.Account;
import com.example.prog4final.model.Transaction;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class TransactionImplementation implements TransactionDAO{
    private Connection connection;

    public TransactionImplementation(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Transaction transaction) {

    }

    @Override
    public List<Transaction> findAll() throws SQLException {
        List<Transaction> findTransaction =new ArrayList<>();
        String sql="SELECT * FROM transaction JOIN account ON transaction.id_account_transaction = account.id_account";;
        try (PreparedStatement preparedStatement= connection.prepareStatement(sql)){
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                findTransaction.add(new Transaction(
                        resultSet.getInt("id_transaction"),
                        resultSet.getTimestamp("dateTransaction"),
                        resultSet.getDouble("amount"),
                        resultSet.getString("type"),
                        resultSet.getString("reason"),
                        new Account(  resultSet.getInt("id_account"),
                                resultSet.getString("lastName"),
                                resultSet.getString("firstName"),
                                resultSet.getDate("birthDate"),
                                resultSet.getDouble("salary"),
                                resultSet.getString("accountNumber"))
                ));

            }
        }
            catch (SQLException e) {
                System.out.println("---un erreur se produit lors de l'execution---"+e.getMessage());
        }
        return findTransaction;
    }

    @Override
    public List<Transaction> findByIdAccount(int id_account_transaction) throws SQLException {
        List<Transaction> allTransactionOfAccount = new ArrayList<>();
        String sql = "SELECT * from Transaction JOIN account ON transaction.id_account_transaction=account.id_account WHERE id_account=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id_account_transaction);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                allTransactionOfAccount.add(new Transaction(
                        resultSet.getInt("id_transaction"),
                        resultSet.getTimestamp("dateTransaction"),
                        resultSet.getDouble("amount"),
                        resultSet.getString("type"),
                        resultSet.getString("reason"),
                        new Account(resultSet.getInt("id_account"),
                                resultSet.getString("lastName"),
                                resultSet.getString("firstName"),
                                resultSet.getDate("birthDate"),
                                resultSet.getDouble("salary"),
                                resultSet.getString("accountNumber"))
                ));

            }
        } catch (SQLException e) {
            System.out.println("---un erreur se produit lors de l'execution---" + e.getMessage());

        }
        return allTransactionOfAccount;
    }
}
