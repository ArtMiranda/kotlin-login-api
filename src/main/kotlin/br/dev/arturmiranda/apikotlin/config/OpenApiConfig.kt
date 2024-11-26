package br.dev.arturmiranda.apikotlin.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

    @Bean
    fun customOpenAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Kotlin API Documentation")
                    .version("1.0.0")
                    .description("API documentation for the Kotlin Spring Boot application")
                    .contact(
                        Contact()
                            .name("Artur Miranda")
                            .email("artcamir12@gmail.com")
                            .url("https://arturmiranda.dev.br")
                    )
            )
    }
}
