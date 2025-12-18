package com.devsu.client_service.service.impl;

import com.devsu.client_service.domain.Client;
import com.devsu.client_service.dto.request.ClientRequest;
import com.devsu.client_service.dto.response.ClientResponse;
import com.devsu.client_service.exception.ResourceNotFoundException;
import com.devsu.client_service.mapper.ClientMapper;
import com.devsu.client_service.repository.ClientRepository;
import com.devsu.client_service.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public ClientResponse create(ClientRequest request) {

        Client client = ClientMapper.toEntity(request);

        Client savedClient = clientRepository.save(client);

        return ClientMapper.toResponse(savedClient);
    }


    @Override
    public ClientResponse getById(UUID id) {

        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Client not found with id: " + id
                ));

        return ClientMapper.toResponse(client);
    }


    @Override
    public List<ClientResponse> getAll() {

        return clientRepository.findAll()
                .stream()
                .map(ClientMapper::toResponse)
                .toList();
    }


    @Override
    public ClientResponse update(UUID id, ClientRequest request) {

        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Client not found with id: " + id
                ));

        existingClient.setClientId(request.clientId());
        existingClient.setPassword(request.password());
        existingClient.setStatement(request.statement());

        existingClient.setName(request.name());
        existingClient.setGender(request.gender());
        existingClient.setAge(request.age());
        existingClient.setIdentification(request.identification());
        existingClient.setAddress(request.address());
        existingClient.setPhone(request.phone());

        Client updatedClient = clientRepository.save(existingClient);

        return ClientMapper.toResponse(updatedClient);
    }

    @Override
    public void delete(UUID id) {

        if (!clientRepository.existsById(id)) {
            throw new ResourceNotFoundException(
                    "Client not found with id: " + id
            );
        }

        clientRepository.deleteById(id);
    }
}

