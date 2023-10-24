package com.be.car_rental.services.mappers.dtoMappers;

import com.be.car_rental.entidades.Client;
import com.be.car_rental.entidades.dto.ClientDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ClientDtoMapper implements Function<Client, ClientDto> {
    @Override
    public ClientDto apply(Client client) {
        ClientDto clientDto = new ClientDto(client.getId(), client.getFirstName(), client.getLastName(),
                client.getSex(), null, client.getCompany().getId());
        clientDto.setBirthDateFromUnixTimestamp(client.getBirthDate());
        return clientDto;
    }
}
