package com.be.car_rental.services;

import com.be.car_rental.entidades.ClientCompany;
import com.be.car_rental.entidades.dto.ClientCompanyDto;
import com.be.car_rental.repositories.ClientCompanyRepository;
import com.be.car_rental.services.mappers.ClientCompanyDtoMapper;
import com.be.car_rental.services.mappers.ClientCompanyEntityMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ClientCompanyServiceImp implements ClientCompanyService{

    private final ClientCompanyRepository clientCompanyRepository;
    private final ClientCompanyDtoMapper dtoMapper;
    private  final ClientCompanyEntityMapper entityMapper;

    public ClientCompanyServiceImp(ClientCompanyRepository clientCompanyRepository,
                                   ClientCompanyDtoMapper dtoMapper,
                                   ClientCompanyEntityMapper entityMapper) {
        this.clientCompanyRepository = clientCompanyRepository;
        this.dtoMapper = dtoMapper;
        this.entityMapper = entityMapper;
    }

    @Override
    public ClientCompanyDto add(ClientCompanyDto entity) {
        Optional<ClientCompany> company = Stream.of(entity).map(entityMapper).findFirst();
        company.ifPresent(clientCompanyRepository::save);
        return company.map(dtoMapper).orElseThrow();
    }

    @Override
    public ClientCompanyDto update(ClientCompanyDto entity) {
        Optional<ClientCompany> company = Stream.of(entity).map(entityMapper).findFirst();
        company.ifPresent(clientCompanyRepository::save);
        return company.map(dtoMapper).orElseThrow();
    }

    @Override
    public ClientCompanyDto delete(Long id) {
        ClientCompanyDto company = this.getById(id);
        Optional<ClientCompany> entity = Stream.of(company).map(entityMapper).findFirst();
        entity.ifPresent(clientCompanyRepository::delete);
        return company;
    }

    @Override
    public ClientCompanyDto getById(Long id) {
        Optional<ClientCompany> company = this.clientCompanyRepository.findById(id);
        return company.map(dtoMapper).orElseThrow();
    }

    @Override
    public List<ClientCompanyDto> getAll() {
        List<ClientCompany> companies = this.clientCompanyRepository.findAll();
        return companies.stream().map(dtoMapper).toList();
    }
}
