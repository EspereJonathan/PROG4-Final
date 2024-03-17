package com.example.prog4final;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBD {
    private static Connection connection;
    private String url = System.getenv("URL");
    private String user=System.getenv("USER");
    private String password = System.getenv("PASSWORD");
    private ConnectionBD(){
        try{
            connection = DriverManager.getConnection(
                    System.getenv("url"),
                    System.getenv("user"),
                    System.getenv("password")
            );
            System.out.println("connecter la base de donner ");
        } catch (SQLException e) {
            System.out.println("----------------erreur de connection------------------");;
        }
    }
    public static Connection getConnection() {
        if (connection==null){
            new ConnectionBD();
        }
        return connection;
    }
}

