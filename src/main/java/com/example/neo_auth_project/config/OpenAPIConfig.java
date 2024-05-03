package com.example.neo_auth_project.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Bahtiyar",
                        email = "baha95t@gmail.com"
                ),
                description = "OpenAPI documentation",
                title = "OpenAPI specification - Bahtiyar",
                version = "1.0"
        ),
        servers = {
                @Server(
                        description = "Railway App",
                        url = "https://neobisauth-production.up.railway.app/"
                )
        }

)
public class OpenAPIConfig {

}

