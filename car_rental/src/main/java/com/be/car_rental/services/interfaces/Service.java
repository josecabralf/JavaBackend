package com.be.car_rental.services.interfaces;

import java.util.List;

public interface Service <T, ID>{
    T add(T entity);

    T update(T entity);

    T delete(ID id);

    T getById(ID id);

    List<T> getAll();
}
