package com.example.modelo_parcial.controllers;

import com.example.modelo_parcial.entities.Address;
import com.example.modelo_parcial.services.Interfaces.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses") // Ruta base para las operaciones relacionadas con las direcciones
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable Long id) {
        return addressService.getById(id);
    }

    @GetMapping("/")
    public List<Address> getAllAddresses() {
        return addressService.getAll();
    }

    @PostMapping("/")
    public Address addAddress(@RequestBody Address address) {
        return addressService.add(address);
    }

    @PutMapping("/{id}")
    public Address updateAddress(@PathVariable Long id, @RequestBody Address updatedAddress) {
        updatedAddress.setAddressId(id);
        return addressService.update(updatedAddress);
    }

    @DeleteMapping("/{id}")
    public Address deleteAddress(@PathVariable Long id) {
        return addressService.delete(id);
    }
}
