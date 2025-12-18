package com.devsu.client_service.dto.request;

import com.devsu.client_service.domain.enums.Gender;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClientRequest (

    @NotBlank(message = "Name is required")
    String name,

    @NotBlank(message = "Lastname is required")
    String lastname,

    @Min(value = 18, message = "Client must be at least 18 years old")
    Integer age,

    @NotBlank
    String identification,

    @NotBlank
    String clientId,

    @NotBlank
    String password,

    @NotNull
    Boolean statement,

    Gender gender,
    String address,
    String phone
)
{}
