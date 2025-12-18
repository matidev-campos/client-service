package com.devsu.client_service.controller;

import com.devsu.client_service.dto.request.ClientRequest;
import com.devsu.client_service.dto.response.ClientResponse;
import com.devsu.client_service.mapper.ClientMapper;
import com.devsu.client_service.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Clients", description = "Client management API")
@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Operation(summary = "Create a new client")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientResponse create(@Valid @RequestBody ClientRequest request) {
        return clientService.create(request);
    }

    @Operation(summary = "Get client by id")
    @GetMapping("/{id}")
    public ClientResponse getById(@PathVariable UUID id) {
        return clientService.getById(id);
    }

    @Operation(summary = "Get all clients")
    @GetMapping
    public List<ClientResponse> getAll() {
        return clientService.getAll();
    }

    @Operation(summary = "Update client by id")
    @PutMapping("/{id}")
    public ClientResponse update(
            @PathVariable UUID id,
            @Valid @RequestBody ClientRequest request) {
        return clientService.update(id, request);
    }

    @Operation(summary = "Delete client by id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        clientService.delete(id);
    }
}

