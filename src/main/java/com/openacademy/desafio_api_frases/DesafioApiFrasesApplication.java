package com.openacademy.desafio_api_frases;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DesafioApiFrasesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioApiFrasesApplication.class, args);
	}

}
