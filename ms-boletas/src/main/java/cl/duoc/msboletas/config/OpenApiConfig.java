package cl.duoc.msboletas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Boletas API")
                        .version("2.0")
                        .description("API para la gestión de boletas en el sistema financiero")
                        .contact(new Contact()
                                .name("Equipo de Desarrollo")
                                .email("desarrollo@duoc.cl")
                                .url("https://www.duoc.cl/")));
    }
}