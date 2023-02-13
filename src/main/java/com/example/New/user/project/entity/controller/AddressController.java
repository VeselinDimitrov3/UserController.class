package com.example.New.user.project.entity.controller;


import com.example.New.user.project.entity.Address;
import com.example.New.user.project.entity.controller.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @GetMapping (path = "getAddress/{id}")
    public Address getAddress (@PathVariable Long id) {
        return this.addressService.getById(id);
    }
    @PostMapping (path = "createAddress/add")
    public Address createAddress (@RequestBody Address address) {
        return this.addressService.saveAddresses(address);
    }
    @DeleteMapping (path = "deleteAddress/delete")
    public String deleteAddress (@PathVariable Long id) {
        this.addressService.deleteById(id);
        return String.format("Address with this id is deleted", id);


    }

}
