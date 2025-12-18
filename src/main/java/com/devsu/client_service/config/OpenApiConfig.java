package com.devsu.client_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI clientServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Client Service API")
                        .description("CRUD de clientes - Devsu Challenge")
                        .version("1.0.0"));
    }
}
