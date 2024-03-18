package com.example.prog4final;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Configuration
public class ConnectionBD {
    private String url = System.getenv("URL");
    private String user=System.getenv("USER");
    private String password = System.getenv("PASSWORD");
    @Bean
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                url,
                user,
                password);
    }
}

