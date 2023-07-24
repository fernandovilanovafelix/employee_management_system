package br.com.mjv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customConfig() {
		return new OpenAPI().components(new Components())
				.info(new Info().title("Employee Management API").description("This is a REST API Documentation"));
	}

}
