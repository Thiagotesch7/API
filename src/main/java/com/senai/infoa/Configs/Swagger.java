package com.senai.infoa.Configs;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "FabLab",
        version = "1.0",
        description = "Caio Borsato Alonso e Marlon Lara Cardoso"
    )
)
public class Swagger {

}