package com.example.modelo_parcial.services.Mappers;

import com.example.modelo_parcial.entities.Address;
import com.example.modelo_parcial.entities.Dto.AddressDto;

import java.util.ArrayList;
import java.util.function.Function;

public class AddressMapper implements Function<AddressDto, Address> {
    @Override
    public Address apply(AddressDto address) {
        return new Address(address.getAddressId(), address.getAddress(), address.getAddress2(),
                address.getDistrict(), address.getCityID(), address.getPostalCode(), address.getPhone(),
                address.getLastUpdate(), new ArrayList<>(), new ArrayList<>());
    }
}
