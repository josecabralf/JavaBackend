package com.example.modelo_parcial.services.Implementations;

import com.example.modelo_parcial.entities.Inventory;
import com.example.modelo_parcial.repositories.InventoryRepository;
import com.example.modelo_parcial.services.Interfaces.InventoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImp implements InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryServiceImp(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public Inventory add(Inventory entity) {
        return null;
    }

    @Override
    public Inventory update(Inventory entity) {
        return null;
    }

    @Override
    public Inventory delete(Long aLong) {
        return null;
    }

    @Override
    public Inventory getById(Long aLong) {
        return null;
    }

    @Override
    public List<Inventory> getAll() {
        return null;
    }
}
