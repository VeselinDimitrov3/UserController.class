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
import java.util.*;

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
        createRole();
        createUsers();
        createAddress();
        getUser();
        getAddress();
    }

    public List<Role> createRole() {
        Role role1 = new Role();
        role1.setAuthority("ADMIN");
        Role role2 = new Role();
        role2.setAuthority("USER");
        Role role3 = new Role();
        role3.setAuthority("CLIENT");
        List<Role> roles = List.of(role1, role2, role3);
        roleRepository.saveAll(roles);
        return roles;
    }

    public void createUsers() {
        List<Role> authority = createRole();
        List<Address> addresses = createAddress();
        User user = new User();
        user.setFirst_name("Ivan");
        user.setLast_name("Ivanov");
        user.setPhone_number("3453425234");
        user.setEmail("ipofdhjifdh@gmail.com");
        user.setPassword("");
        user.setCreatedAt(Instant.now());
        Set<Role> roleList = new HashSet<>(authority);
        user.setAuthority(Collections.singleton(authority.get(0)));



        List<Role> authority2 = createRole();
        List<Address> addresses2 = createAddress();
        User user2 = new User();
        user2.setFirst_name("Petar");
        user2.setLast_name("Georgiev");
        user2.setPhone_number("54363467363");
        user2.setEmail("gfjhtrurtuy@gmail.com");
        user2.setPassword("");
        user2.setCreatedAt(Instant.now());
        Set<Role> roleList2 = new HashSet<>(authority2);
        user2.setAuthority(Collections.singleton(authority.get(1)));


        roleRepository.saveAll(roleList);
        roleRepository.saveAll(roleList2);

        userRepository.save(user);
        userRepository.save(user2);

    }

    public List<Address> createAddress() {

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

        List<Address> addresses = List.of(address, address2);
        addressRepository.saveAll(addresses);

        return addresses;
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
