package com.devsu.client_service.messaging.producer;

import com.devsu.client_service.config.RabbitMQConfig;
import com.devsu.client_service.messaging.event.ClientCreatedEvent;
import com.devsu.client_service.messaging.event.ClientDeletedEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ClientEventProducer {

    private final RabbitTemplate rabbitTemplate;

    public ClientEventProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendClientCreated(UUID clientId, String name, String identification) {
        ClientCreatedEvent event =
                new ClientCreatedEvent(clientId, name, identification);

        rabbitTemplate.convertAndSend(
                RabbitMQConfig.CLIENT_EVENTS_EXCHANGE,
                "client.created",
                event
        );
    }

    public void sendClientDeleted(UUID clientId) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.CLIENT_EVENTS_EXCHANGE,
                "client.deleted",
                new ClientDeletedEvent(clientId)
        );
    }
}

