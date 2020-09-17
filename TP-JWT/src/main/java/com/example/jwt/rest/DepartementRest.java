package com.example.jwt.rest;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt.bean.Departement;
import com.example.jwt.service.DepartementImpl;

@RestController
@RequestMapping("/tp-jwt/departement")
@CrossOrigin(origins = "http://localhost:4200")
public class DepartementRest {

	@Autowired
	private DepartementImpl departementImpl;

	@PostMapping("/")
	public Departement save(@RequestBody Departement departement) {
		return departementImpl.save(departement);
	}

	@GetMapping("/")
	public List<Departement> findAll() {
		return departementImpl.findAll();
	}

	@Transactional
	@DeleteMapping("/delete/id/{id}")
	public int deleteById(@PathVariable Long id) {
		return departementImpl.deleteById(id);
	}

	@PutMapping("/update/")
	public int update(@RequestBody Departement departement) {
		return departementImpl.update(departement);
	}
	
	
}
