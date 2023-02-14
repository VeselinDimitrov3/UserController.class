package com.example.New.user.project.entity.runner;

import com.example.New.user.project.entity.Address;
import com.example.New.user.project.entity.User;
import com.example.New.user.project.entity.Role;
import com.example.New.user.project.entity.repositories.AddressRepository;
import com.example.New.user.project.entity.repositories.RoleRepository;
import com.example.New.user.project.entity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class CommandRunner implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {

        Role role1 = new Role();
        role1.setRole("ADMIN");
        Role role2 = new Role();
        role2.setRole("USER");
        Role role3 = new Role();
        role3.setRole("CLIENT");

        User user = new User();
        user.setFirst_name("Ivan");
        user.setLast_name("Ivanov");
        user.setPhone_number("3453425234");
        user.setEmail("ipofdhjifdh@gmail.com");
        user.setCreatedAt(Instant.now());

        User user2 = new User();
        user2.setFirst_name("Petar");
        user2.setLast_name("Georgiev");
        user2.setPhone_number("54363467363");
        user2.setEmail("gfjhtrurtuy@gmail.com");
        user2.setCreatedAt(Instant.now());

        List<Role> rolesList = List.of(role1, role2, role3);
        List<Role> savedRoles = roleRepository.saveAll(rolesList);

        Set<Role> rolesForUser = new HashSet<>(savedRoles);
        user.setRoles(rolesForUser);

        userRepository.save(user);
        userRepository.save(user2);

        System.out.println(savedRoles);

        Address address = new Address();
        address.setCountry("Bulgaria");
        address.setCity("Varna");
        address.setStreet("Boulevard Vladislav Varnenchik");
        address.setStreet_number(70);

        Address address2 = new Address();
        address2.setCountry("Bulgaria");
        address2.setCity("Sofia");
        address2.setStreet("Mladost");
        address2.setStreet_number(88);

        addressRepository.save(address);
        addressRepository.save(address2);

        getUser();
        getAddress();

    }

    public void getUser () {
        Optional<User> user = userRepository.findById(1L);
        user.ifPresent(value -> System.out.println());

    }

    public void getAddress () {
        Optional<Address> address = addressRepository.findById(1L);
        address.ifPresent(value -> System.out.println());
    }


}
