package ar.edu.frc.utn.bda3k4.northwind.services.interfaces;

import ar.edu.frc.utn.bda3k4.northwind.entities.Order;

public interface OrderDetailsFilteredAdder {
    Order addDetails(Order order, Integer supplierId, Integer categoryId, Integer requiredStock);
}
