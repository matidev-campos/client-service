package com.devsu.client_service.controller;

import com.devsu.client_service.domain.Client;
import com.devsu.client_service.dto.request.ClientRequest;
import com.devsu.client_service.dto.response.ClientResponse;
import com.devsu.client_service.mapper.ClientMapper;
import com.devsu.client_service.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;

    public ClientController(ClientService clientService, ClientMapper clientMapper) {
        this.clientService = clientService;
        this.clientMapper = clientMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientResponse create(@Valid @RequestBody ClientRequest request) {
        return clientService.create(request);
    }

    @GetMapping("/{id}")
    public ClientResponse getById(@PathVariable UUID id) {
        return clientService.getById(id);
    }

    @GetMapping
    public List<ClientResponse> getAll() {
        return clientService.getAll();
    }

    @PutMapping("/{id}")
    public ClientResponse update(
            @PathVariable UUID id,
            @Valid @RequestBody ClientRequest request) {
        return clientService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        clientService.delete(id);
    }
}

