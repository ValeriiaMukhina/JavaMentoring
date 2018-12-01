package com.epam.trainings.servletwithspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public String message() {
		return "Spring is working";
	}
	
}
