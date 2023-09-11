package com.devmare.springadminuserauth.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String email;
    private String password;
    private String role;
    private String fullName;

    public User(String email, String password, String role, String fullName) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.fullName = fullName;
    }
}
