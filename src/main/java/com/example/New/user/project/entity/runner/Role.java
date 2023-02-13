package com.example.New.user.project.entity.runner;

import com.example.New.user.project.entity.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Data
@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private UserRole role;

    @Column
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

}
