package com.example.modelo_parcial.services.Mappers;

import com.example.modelo_parcial.entities.Address;
import com.example.modelo_parcial.entities.Dto.AddressDto;

import java.util.function.Function;

public class AddressDtoMapper implements Function<Address, AddressDto> {

    @Override
    public AddressDto apply(Address address) {
        return new AddressDto(address.getAddressId(), address.getAddress(), address.getAddress2(),
                address.getDistrict(), address.getCityID(), address.getPostalCode(), address.getPhone(),
                address.getLastUpdate());
    }
}
