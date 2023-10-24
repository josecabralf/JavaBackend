package com.be.car_rental.controllers;

import com.be.car_rental.entidades.dto.ClientDto;
import com.be.car_rental.services.interfaces.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients") // http://localhost:8080/api/clients
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<ClientDto>> getAll(){
        List<ClientDto> values = this.clientService.getAll();
        return ResponseEntity.ok(values);
    }

    @PostMapping
    public ResponseEntity<ClientDto> add(@RequestBody ClientDto client){
        ClientDto addedClient = this.clientService.add(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClientDto> delete(@PathVariable Long id) {
        ClientDto deletedClient = this.clientService.delete(id);
        if (deletedClient != null) return ResponseEntity.ok(deletedClient);
        else return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getById(@PathVariable Long id) {
        ClientDto client = this.clientService.getById(id);
        if (client != null) return ResponseEntity.ok(client);
        else return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDto> update(@PathVariable Long id, @RequestBody ClientDto client) {
        client.setId(id);
        ClientDto updatedClient = this.clientService.update(client);
        if (updatedClient != null) return ResponseEntity.ok(updatedClient);
        else return ResponseEntity.notFound().build();
    }
}
