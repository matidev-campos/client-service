package com.devsu.client_service.service;

import com.devsu.client_service.domain.Client;

import java.util.List;
import java.util.UUID;

public interface ClientService {

    Client create(Client client);

    Client findById(UUID id);

    List<Client> findAll();

    Client update(UUID id, Client client);

    void delete(UUID id);
}
