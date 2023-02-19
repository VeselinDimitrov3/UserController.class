package com.example.New.user.project.entity.model;

import com.example.New.user.project.entity.Role;
import com.example.New.user.project.entity.User;
import com.example.New.user.project.entity.controller.service.RoleService;
import com.example.New.user.project.entity.impl.RoleImpl;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.management.relation.RoleNotFoundException;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Component
@NoArgsConstructor
public class UserRequest implements Serializable {

    public static RoleImpl roleService;
    @Autowired
    public UserRequest (RoleImpl roleService){
        UserRequest.roleService = roleService;
    }

    @NotNull(message = "Name could not be null")
    @Size(min = 3, max = 50, message = "Name should be between 3 and 50 characters")
    private String first_name;
    private String last_name;
    @Email
    private String email;
    private String password;
    private String phone_number;
    private Instant createdAt;
    @JsonProperty("user_roles")
    private ArrayList<String> userRoles = new ArrayList<>();

    public User convert () {
        return User.builder()
                .first_name(this.getFirst_name())
                .last_name(this.getLast_name())
                .phone_number(this.getPhone_number())
                .email(this.getEmail())
                .createdAt(Instant.now())
                .authority(setAuthority(userRoles))
                .password(this.getPassword())
                .build();
    }
    private Set<Role> setAuthority(ArrayList<String> userRoles) {
        Set<Role> registeredRoles = new HashSet<>();

        for (int i = 0; i < userRoles.size(); i++) {
            try {
                registeredRoles.add(roleService.getByAuthority(userRoles.get(i)));
            } catch (RoleNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return registeredRoles;

    }


}
