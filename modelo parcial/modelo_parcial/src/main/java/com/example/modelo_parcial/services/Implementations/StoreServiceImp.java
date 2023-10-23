package com.example.modelo_parcial.services.Implementations;

import com.example.modelo_parcial.entities.Store;
import com.example.modelo_parcial.repositories.StoreRepository;
import com.example.modelo_parcial.services.Interfaces.StoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImp implements StoreService {

    private final StoreRepository storeRepository;

    public StoreServiceImp(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public Store add(Store entity) {
        return null;
    }

    @Override
    public Store update(Store entity) {
        return null;
    }

    @Override
    public Store delete(Long aLong) {
        return null;
    }

    @Override
    public Store getById(Long aLong) {
        return null;
    }

    @Override
    public List<Store> getAll() {
        return null;
    }
}
