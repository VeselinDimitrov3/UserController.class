package com.example.New.user.project.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.time.Instant;


@Data
@Getter
@Setter
@Entity(name = "Users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "phone_number")
    private String phone_number;
    @Column(name = "email")
    private String email;
    @Column(name = "date of creation")
    private Instant createdAt;

}
