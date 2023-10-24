package com.be.car_rental.controllers;

import com.be.car_rental.entidades.dto.ClientCompanyDto;
import com.be.car_rental.services.interfaces.ClientCompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies") // http://localhost:8080/api/companies
public class ClientCompanyController {

    private final ClientCompanyService clientCompanyService;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<ClientCompanyDto> delete(@PathVariable Long id) {
        ClientCompanyDto deletedCompany = this.clientCompanyService.delete(id);
        if (deletedCompany != null) return ResponseEntity.ok(deletedCompany);
        else return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientCompanyDto> getById(@PathVariable Long id) {
        ClientCompanyDto company = this.clientCompanyService.getById(id);
        if (company != null) return ResponseEntity.ok(company);
        else return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientCompanyDto> update(@PathVariable Long id, @RequestBody ClientCompanyDto clientCompany) {
        clientCompany.setId(id);
        ClientCompanyDto updatedCompany = this.clientCompanyService.update(clientCompany);
        if (updatedCompany != null) return ResponseEntity.ok(updatedCompany);
        else return ResponseEntity.notFound().build();
    }

}
