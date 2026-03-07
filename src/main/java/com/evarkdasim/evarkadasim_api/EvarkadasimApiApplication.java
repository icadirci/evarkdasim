package com.evarkdasim.evarkadasim_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EvarkadasimApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvarkadasimApiApplication.class, args);
	}

}
