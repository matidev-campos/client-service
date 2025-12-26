package com.devsu.client_service.messaging.producer;

import com.devsu.client_service.config.RabbitMQConfig;
import com.devsu.client_service.messaging.event.ClientCreatedEvent;
import com.devsu.client_service.messaging.event.ClientDeletedEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

@Component
public class ClientEventProducer {

    private static final Logger log =
            LoggerFactory.getLogger(ClientEventProducer.class);

    private final RabbitTemplate rabbitTemplate;

    public ClientEventProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendClientCreated(UUID clientId, String name, String identification) {

        ClientCreatedEvent event =
                new ClientCreatedEvent(clientId, name, identification);

        log.info(
                "Publishing ClientCreatedEvent | clientId={} | exchange={} | routingKey={}",
                clientId,
                RabbitMQConfig.CLIENT_EVENTS_EXCHANGE,
                "client.created"
        );

        rabbitTemplate.convertAndSend(
                RabbitMQConfig.CLIENT_EVENTS_EXCHANGE,
                "client.created",
                event
        );
    }

    public void sendClientDeleted(UUID clientId) {
        log.info(
                "📤 Publishing ClientDeletedEvent | clientId={} | exchange={} | routingKey={}",
                clientId,
                RabbitMQConfig.CLIENT_EVENTS_EXCHANGE,
                "client.deleted"
        );
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.CLIENT_EVENTS_EXCHANGE,
                "client.deleted",
                new ClientDeletedEvent(clientId)
        );
    }
}

