package com.example.teste.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")

public class User implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "LOGIN_ID")
    private UUID id;

    @Column(nullable = false, unique = true,name = "LOGIN_NAME")
    private String login;

    @Column(nullable = false, name = "PASSWORD")
    private String password;


}
