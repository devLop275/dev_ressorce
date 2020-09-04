package com.example.jwt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt.bean.DemandeConge;
import com.example.jwt.service.DemandeCongeImpl;
@RestController
@RequestMapping("/tp-jwt/demandeConge")
@CrossOrigin(origins = "http://localhost:4200")
public class DemandeCongeRest {

	@Autowired
	private DemandeCongeImpl demandeCongeImpl;

	@PostMapping("/")
	public DemandeConge save(@RequestBody DemandeConge demandeConge) {
		return demandeCongeImpl.save(demandeConge);
	}

	@GetMapping("/")
	public List<DemandeConge> findAll() {
		return demandeCongeImpl.findAll();
	}
	
	
}
