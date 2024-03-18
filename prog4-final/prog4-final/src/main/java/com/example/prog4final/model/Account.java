package com.example.prog4final.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Date;
@Getter
@AllArgsConstructor
@Setter
@ToString
public class Account {
    private int id_account;
    private String lastName;
    private String firstName;
    private Date birthDate;
    private double salary;
    private String accountNumber;
}
