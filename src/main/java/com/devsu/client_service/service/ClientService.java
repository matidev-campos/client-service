package com.devsu.client_service.service;

import com.devsu.client_service.dto.request.ClientRequest;
import com.devsu.client_service.dto.response.ClientResponse;

import java.util.List;
import java.util.UUID;

public interface ClientService {

    ClientResponse create(ClientRequest request);

    ClientResponse getById(UUID id);

    List<ClientResponse> getAll();

    ClientResponse update(UUID id, ClientRequest request);

    void delete(UUID id);
}
