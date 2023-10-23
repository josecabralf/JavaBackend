package com.be.car_rental.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "client_companies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email_contact")
    private String emailContact;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<Client> clientList;
}
