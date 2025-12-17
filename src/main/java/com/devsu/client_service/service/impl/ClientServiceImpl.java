package com.devsu.client_service.service.impl;

import com.devsu.client_service.domain.Client;
import com.devsu.client_service.repository.ClientRepository;
import com.devsu.client_service.service.ClientService;
import com.devsu.client_service.exception.ResourceNotFoundException;
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
    public Client create(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client findById(UUID id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Client not found with id: " + id
                ));
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client update(UUID id, Client client) {
        Client existing = findById(id);

        existing.setName(client.getName());
        existing.setPhone(client.getPhone());

        return clientRepository.save(existing);
    }

    @Override
    public void delete(UUID id) {
        Client existing = findById(id);
        clientRepository.delete(existing);
    }
}
