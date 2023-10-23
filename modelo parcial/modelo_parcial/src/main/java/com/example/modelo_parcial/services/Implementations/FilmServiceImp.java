package com.example.modelo_parcial.services.Implementations;

import com.example.modelo_parcial.entities.Film;
import com.example.modelo_parcial.repositories.FilmRepository;
import com.example.modelo_parcial.services.Interfaces.FilmService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImp implements FilmService {
    private final FilmRepository filmRepository;

    public FilmServiceImp(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public Film add(Film entity) {
        return null;
    }

    @Override
    public Film update(Film entity) {
        return null;
    }

    @Override
    public Film delete(Long aLong) {
        return null;
    }

    @Override
    public Film getById(Long aLong) {
        return null;
    }

    @Override
    public List<Film> getAll() {
        return null;
    }
}
