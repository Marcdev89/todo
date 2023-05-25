package com.omc.todo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String username;
    private String password;
    @Embedded
    private Address address;

    public User(String name, String username, String password, Address address) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.address = address;
    }

}
