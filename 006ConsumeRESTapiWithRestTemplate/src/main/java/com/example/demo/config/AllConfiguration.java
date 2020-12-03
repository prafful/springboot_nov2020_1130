package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AllConfiguration {
	
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
