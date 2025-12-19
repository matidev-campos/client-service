package com.devsu.client_service.config;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String CLIENT_EVENTS_EXCHANGE = "client.events.exchange";

    @Bean
    public TopicExchange clientEventsExchange() {
        return new TopicExchange(CLIENT_EVENTS_EXCHANGE);
    }
}
