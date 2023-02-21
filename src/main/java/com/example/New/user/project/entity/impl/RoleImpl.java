package com.example.New.user.project.entity.impl;

import com.example.New.user.project.entity.Role;
import com.example.New.user.project.entity.controller.service.RoleService;
import com.example.New.user.project.entity.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;


@Service
public class RoleImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getByAuthority(String role) throws RoleNotFoundException {
        return roleRepository.findByAuthority(role).orElseThrow(RoleNotFoundException::new);


    }
}
