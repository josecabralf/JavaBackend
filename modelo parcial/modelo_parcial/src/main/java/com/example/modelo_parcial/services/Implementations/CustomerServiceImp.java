package com.example.modelo_parcial.services.Implementations;

import com.example.modelo_parcial.entities.Customer;
import com.example.modelo_parcial.repositories.CustomerRepository;
import com.example.modelo_parcial.services.Interfaces.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImp(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer add(Customer entity) {
        return null;
    }

    @Override
    public Customer update(Customer entity) {
        return null;
    }

    @Override
    public Customer delete(Long aLong) {
        return null;
    }

    @Override
    public Customer getById(Long aLong) {
        return null;
    }

    @Override
    public List<Customer> getAll() {
        return null;
    }
}
