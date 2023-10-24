package com.be.car_rental.services.mappers.entityMappers;

import com.be.car_rental.entidades.Client;
import com.be.car_rental.entidades.ClientCompany;
import com.be.car_rental.entidades.dto.ClientDto;
import com.be.car_rental.repositories.ClientCompanyRepository;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ClientEntityMapper implements Function<ClientDto, Client> {

    private final ClientCompanyRepository clientCompanyRepository;

    public ClientEntityMapper(ClientCompanyRepository clientCompanyRepository) {
        this.clientCompanyRepository = clientCompanyRepository;
    }

    @Override
    public Client apply(ClientDto clientDto) {
        Client client = new Client(clientDto.getId(), clientDto.getFirstName(), clientDto.getLastName(),
                clientDto.getSex(), clientDto.getBirthDateAsUnixTimestamp(), null);
        if (clientDto.getCompany() != null) {
            ClientCompany company = clientCompanyRepository.findById(clientDto.getCompany()).orElse(null);
            client.setCompany(company);}
        return client;
    }
}

