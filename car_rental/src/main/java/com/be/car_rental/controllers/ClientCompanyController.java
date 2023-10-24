package com.be.car_rental.controllers;

import com.be.car_rental.entidades.ClientCompany;
import com.be.car_rental.entidades.dto.ClientCompanyDto;
import com.be.car_rental.services.ClientCompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client/company") // http://localhost:8080/api/clients/company
public class ClientCompanyController {

    private ClientCompanyService clientCompanyService;

    public ClientCompanyController(ClientCompanyService clientCompanyService){
        this.clientCompanyService = clientCompanyService;
    }

    @GetMapping
    public ResponseEntity<List<ClientCompanyDto>> getAll(){
        List<ClientCompanyDto> values = this.clientCompanyService.getAll();
        return ResponseEntity.ok(values);
    }

    @PostMapping
    public ResponseEntity<ClientCompanyDto> add(@RequestBody ClientCompanyDto clientCompany){
        ClientCompanyDto company = this.clientCompanyService.add(clientCompany);
        return ResponseEntity.status(HttpStatus.CREATED).body(company);
    }

}
