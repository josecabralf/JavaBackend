package com.example.modelo_parcial.services.Implementations;

import com.example.modelo_parcial.entities.Address;
import com.example.modelo_parcial.repositories.AddressRepository;
import com.example.modelo_parcial.services.Interfaces.AddressService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImp implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImp(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address add(Address entity) {
        return addressRepository.save(entity);
    }

    @Override
    public Address update(Address entity) {
        return addressRepository.save(entity);
    }

    @Override
    public Address delete(Long addressId) {
        Optional<Address> addressOptional = addressRepository.findById(addressId);
        if (addressOptional.isPresent()) {
            Address address = addressOptional.get();
            addressRepository.delete(address);
            return address;
        } else {
            return null;
        }
    }

    @Override
    public Address getById(Long addressId) {
        Optional<Address> addressOptional = addressRepository.findById(addressId);
        return addressOptional.orElse(null);
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }
}
