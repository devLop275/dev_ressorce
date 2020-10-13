package com.example.jwt;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jwt.service.DemandeCongeImpl;

@SpringBootApplication
public class TpJwtApplication {
	
	@Resource
	DemandeCongeImpl demandeCongeImpl;

	public static void main(String[] args) {
		SpringApplication.run(TpJwtApplication.class, args);
	}
	
	public void run(String... arg) throws Exception {
		demandeCongeImpl.init();
	}

}
