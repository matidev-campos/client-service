package com.devsu.client_service.messaging.event;

import java.util.UUID;

public record ClientDeletedEvent(
        UUID clientId
) {
}
