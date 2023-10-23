package com.example.modelo_parcial.entities.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private long addressId;
    private String address;
    private String address2;
    private String district;
    private int cityID;
    private int postalCode;
    private String phone;
    private Date lastUpdate;
}
