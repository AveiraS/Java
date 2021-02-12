package com.cloud.stream.api.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI springShopOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Архив системы")
                        .description("")
                        .version(""))
                        .externalDocs(new ExternalDocumentation()
                        .description("")
                        .url(""));
    }
}
