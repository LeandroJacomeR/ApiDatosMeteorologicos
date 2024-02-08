package com.lj.api.datos.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiSwagger {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("Api de datos meteorologicos")
                        .version("1.0")
                        .description("Api de datos meteorologicos documentacion con swagger")
                        .termsOfService("http://swagger.io/terms")
                        .license(new License().name("Apache License, Version 2.0").url("http://springdoc.org")));
    }
}
