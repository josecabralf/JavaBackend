package com.be.car_rental.services.mappers;

import com.be.car_rental.entidades.ClientCompany;
import com.be.car_rental.entidades.dto.ClientCompanyDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.function.Function;

@Service
public class ClientCompanyEntityMapper implements Function<ClientCompanyDto, ClientCompany> {
    public ClientCompany apply(ClientCompanyDto clientCompanyDto) {
        return new ClientCompany(clientCompanyDto.getId(), clientCompanyDto.getName(),
                clientCompanyDto.getPhoneNumber(), clientCompanyDto.getEmailContact(),
                null);
    }
}
