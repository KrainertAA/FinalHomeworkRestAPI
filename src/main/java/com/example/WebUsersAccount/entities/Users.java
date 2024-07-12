package com.example.WebUsersAccount.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@Entity
@Table(name = "users_account")
@Component
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "balance")
    private int balance;
}