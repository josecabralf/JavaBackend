package com.be.car_rental.services.mappers;

import com.be.car_rental.entidades.ClientCompany;
import com.be.car_rental.entidades.dto.ClientCompanyDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ClientCompanyDtoMapper implements Function<ClientCompany, ClientCompanyDto> {
    @Override
    public ClientCompanyDto apply(ClientCompany clientCompany) {
        return new ClientCompanyDto(clientCompany.getId(), clientCompany.getName(),
                clientCompany.getPhoneNumber(), clientCompany.getEmailContact());
    }
}
