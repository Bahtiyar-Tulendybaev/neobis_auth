package com.example.neo_auth_project.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Neo Auth Project",
                        email = "baha95t@gmail.com"

                ),
                title = "OpenAPI specification - Bahtiyar",
                description = "OpenApi documentation Auth Project",
                version = "0.0.1"
        ),
        servers = {
                @Server(
                        description = "Railway App",
                        url = "https://neobisauth-production.up.railway.app/"
                )
        }
)
public class OpenApiConfig {
}