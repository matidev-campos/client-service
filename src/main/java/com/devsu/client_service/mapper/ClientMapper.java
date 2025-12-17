package com.devsu.client_service.mapper;

import com.devsu.client_service.domain.Client;
import com.devsu.client_service.dto.request.ClientRequest;
import com.devsu.client_service.dto.response.ClientResponse;

public class ClientMapper {

    public static Client toEntity(ClientRequest dto) {
        Client client = new Client();
        client.setName(dto.name());
        client.setLastname(dto.lastname());
        client.setAge(dto.age());
        client.setIdentification(dto.identification());
        client.setAddress(dto.address());
        client.setPhone(dto.phone());
        client.setGender(dto.gender());
        client.setClientId(dto.clientId());
        client.setPassword(dto.password());
        client.setStatement(dto.statement());
        return client;
    }

    public static ClientResponse toResponse(Client client) {
        return new ClientResponse(
                client.getId(),
                client.getName(),
                client.getLastname(),
                client.getIdentification(),
                client.getClientId(),
                client.getStatement()
        );
    }
}


