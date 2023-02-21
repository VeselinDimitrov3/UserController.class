package com.example.New.user.project.entity.controller.service;

import com.example.New.user.project.entity.Role;
import com.example.New.user.project.entity.repositories.RoleRepository;

import javax.management.relation.RoleNotFoundException;

public interface RoleService {
    Role getByAuthority(String authority) throws RoleNotFoundException;


}
