package com.example.modelo_parcial.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor // Lombok genera constructor con/sin argumentos
@Entity(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private long addressId;

    @Column(name = "address")
    private String address;

    @Column(name = "address2")
    private String address2;

    @Column(name = "district")
    private String district;

    @Column(name = "city_id")
    private int cityID;

    @Column(name = "postal_code")
    private int postalCode;

    @Column(name = "phone")
    private String phone;

    @Column(name = "last_update")
    private Date lastUpdate;

    @OneToMany(mappedBy = "address")
    private List<Customer> customers;

    @OneToMany(mappedBy = "address")
    private List<Store> stores;
}
