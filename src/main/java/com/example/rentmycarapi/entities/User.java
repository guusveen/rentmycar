package com.example.rentmycarapi.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Getter
    @Setter
    private String username;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }
}
