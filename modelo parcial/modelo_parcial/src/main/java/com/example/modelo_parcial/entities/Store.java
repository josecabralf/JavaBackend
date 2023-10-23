package com.example.modelo_parcial.entities;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor // Lombok genera constructor con/sin argumentos
@Entity(name = "store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private long storeId;

    @Column(name = "manager_staff_id")
    private short managerStaffId;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @Column(name = "last_update")
    private Date lastUpdate;

    @OneToMany(mappedBy = "store")
    private List<Customer> customers;

    @OneToMany(mappedBy = "store")
    private List<Inventory> inventories;
}
