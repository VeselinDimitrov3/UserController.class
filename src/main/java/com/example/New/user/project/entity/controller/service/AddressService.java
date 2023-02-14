package com.example.New.user.project.entity.controller.service;

import com.example.New.user.project.entity.Address;
import com.example.New.user.project.entity.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
@Service
public class AddressService {

    AddressRepository addressRepository;

    @Autowired
    public AddressService (AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address saveAddresses (Address address) {
        return this.addressRepository.save(address);
    }

    public Address getById (@RequestBody Long id) {
        return this.addressRepository.findById(id).get();
    }
    public void deleteById (Long id) {
        this.addressRepository.deleteById(id);
    }
}
