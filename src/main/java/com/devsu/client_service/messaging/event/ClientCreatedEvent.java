package com.devsu.client_service.messaging.event;

import java.util.UUID;

public record ClientCreatedEvent(
        UUID clientId,
        String name,
        String identification
) {
}
