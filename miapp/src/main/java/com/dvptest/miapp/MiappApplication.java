package com.dvptest.miapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.dvptest.miapp.repository")
public class MiappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiappApplication.class, args);
	}

}
