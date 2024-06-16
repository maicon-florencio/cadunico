package com.microsservice.cad.cadunico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class CadunicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadunicoApplication.class, args);
	}

}
