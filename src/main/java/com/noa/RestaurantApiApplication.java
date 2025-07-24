package com.noa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
    info = @Info(title = "Restaurant API", version = "1.0", description = "API for restaurant booking app")
)

@SpringBootApplication
public class RestaurantApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestaurantApiApplication.class, args);
    }
}