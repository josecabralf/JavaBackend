package com.be.car_rental.services.implementations;

import com.be.car_rental.entidades.Client;
import com.be.car_rental.entidades.ClientCompany;
import com.be.car_rental.entidades.dto.ClientDto;
import com.be.car_rental.repositories.ClientCompanyRepository;
import com.be.car_rental.repositories.ClientRepository;
import com.be.car_rental.services.interfaces.ClientService;
import com.be.car_rental.services.mappers.dtoMappers.ClientDtoMapper;
import com.be.car_rental.services.mappers.entityMappers.ClientEntityMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ClientServiceImp implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientCompanyRepository clientCompanyRepository;
    private final ClientDtoMapper dtoMapper;
    private final ClientEntityMapper entityMapper;

    public ClientServiceImp(ClientRepository clientRepository, ClientCompanyRepository clientCompanyRepository, ClientDtoMapper dtoMapper, ClientEntityMapper entityMapper) {
        this.clientRepository = clientRepository;
        this.clientCompanyRepository = clientCompanyRepository;
        this.dtoMapper = dtoMapper;
        this.entityMapper = entityMapper;
    }

    @Override
    public ClientDto add(ClientDto entity) {
        Optional<Client> client = Stream.of(entity).map(entityMapper).findFirst();
        if (entity.getCompany() != null) {
            ClientCompany company = this.clientCompanyRepository.findById(entity.getCompany()).orElse(null);
            client.ifPresent(c -> c.setCompany(company));
        }
        if (entity.getBirthDateAsUnixTimestamp() != null) {
            client.ifPresent(c -> c.setBirthDate(entity.getBirthDateAsUnixTimestamp()));
        }
        client.ifPresent(clientRepository::save);
        return client.map(dtoMapper).orElseThrow();
    }
    public ClientDto update(ClientDto entity) {
        Optional<Client> client = Stream.of(entity).map(entityMapper).findFirst();
        if (entity.getCompany() != null) {
            ClientCompany company = clientCompanyRepository.findById(entity.getCompany()).orElse(null);
            client.ifPresent(c -> c.setCompany(company));
        }
        client.ifPresent(clientRepository::save);
        return client.map(dtoMapper).orElseThrow();
    }
    @Override
    public ClientDto delete(Long id) {
        ClientDto client = this.getById(id);
        if (client != null) {
            Optional<Client> entity = Stream.of(client).map(entityMapper).findFirst();
            entity.ifPresent(c -> c.setCompany(null));
            entity.ifPresent(clientRepository::delete);
        }
        return client;
    }
    @Override
    public ClientDto getById(Long id) {
        Optional<Client> client = this.clientRepository.findById(id);
        return client.map(dtoMapper).orElse(null);
    }

    @Override
    public List<ClientDto> getAll() {
        List<Client> client = this.clientRepository.findAll();
        return client.stream().map(dtoMapper).toList();
    }
}
