package com.example.New.user.project.entity.runner;

import com.example.New.user.project.entity.Address;
import com.example.New.user.project.entity.User;
import com.example.New.user.project.entity.repositories.AddressRepository;
import com.example.New.user.project.entity.repositories.UserRepository;
import org.hibernate.mapping.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {


    @Autowired
    UserRepository userRepository;
    @Autowired
    AddressRepository addressRepository;

    @Override
    public void run(String... args) throws Exception {
        createUser();
        createAddress();
    }
    public void createUser() {
        User user = new User();
        user.setId(1L);
        user.setFirst_name("Ivan");
        user.setLast_name("Ivanov");
        user.setPhone_number("3453425234");
        user.setEmail("ipofdhjifdh@gmail.com");
        user.setCreatedAt(Instant.now());
        User user2 = new User();
        user2.setId(2L);
        user2.setFirst_name("Petar");
        user2.setLast_name("Georgiev");
        user2.setPhone_number("54363467363");
        user2.setEmail("gfjhtrurtuy@gmail.com");
        user2.setCreatedAt(Instant.now());

        userRepository.save(user);
        userRepository.save(user2);

    }

    public void createAddress() {
        Address address = new Address();
        address.setId(1L);
        address.setCountry("Bulgaria");
        address.setCity("Varna");
        address.setStreet("Boulevard Vladislav Varnenchik");
        address.setStreet_number(70);

        Address address2 = new Address();
        address2.setId(2L);
        address2.setCountry("Bulgaria");
        address2.setCity("Sofia");
        address2.setStreet("Mladost");
        address2.setStreet_number(88);

        addressRepository.save(address);
        addressRepository.save(address2);


    }

}
