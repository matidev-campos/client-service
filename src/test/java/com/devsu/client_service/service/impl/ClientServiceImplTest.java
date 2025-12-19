package com.devsu.client_service.service.impl;

import com.devsu.client_service.domain.Client;
import com.devsu.client_service.domain.enums.Gender;
import com.devsu.client_service.dto.request.ClientRequest;
import com.devsu.client_service.messaging.producer.ClientEventProducer;
import com.devsu.client_service.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.eq;


import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class ClientServiceImplTest {

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ClientEventProducer eventProducer;

    @InjectMocks
    private ClientServiceImpl clientService;

    @Test
    void shouldPublishEventWhenClientIsCreated() {

        Client client = new Client();
        client.setId(UUID.randomUUID());
        client.setName("Juan");
        client.setIdentification("12345678");

        when(clientRepository.save(any(Client.class)))
                .thenReturn(client);

        ClientRequest request = new ClientRequest(
                "Juan",
                "Perez",
                30,
                "12345678",
                "client-001",
                "password123",
                true,
                Gender.MALE,
                "Calle Falsa 123",
                "123456789"
        );


        clientService.create(request);

        verify(eventProducer)
                .sendClientCreated(
                        any(UUID.class),
                        eq("Juan"),
                        eq("12345678")
                );


    }
}
