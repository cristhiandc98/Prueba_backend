package com.reto_backend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RetoConfig {
	
	@Bean
	public RestTemplate apiConsumer() {
		return new RestTemplate();
	}

}
