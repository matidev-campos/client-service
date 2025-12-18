package com.devsu.client_service.dto.response;

import java.util.UUID;

public record ClientResponse (

     UUID id,
     String name,
     String lastname,
     String identification,
     String clientId,
     Boolean statement
){}

