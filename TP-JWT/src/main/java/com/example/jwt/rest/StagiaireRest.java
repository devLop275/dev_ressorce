package com.example.jwt.rest;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt.bean.Employee;
import com.example.jwt.bean.Stagiaire;
import com.example.jwt.dao.StagiaireDao;
import com.example.jwt.service.StagiaireImpl;

@RestController
@RequestMapping("/tp-jwt/stagiaire")
@CrossOrigin(origins = "http://localhost:4200")
public class StagiaireRest {

	@Autowired
	private StagiaireImpl stagiaireService;

	@PostMapping("/")
	public Stagiaire save(@RequestBody Stagiaire stagiaire) {
		return stagiaireService.save(stagiaire);
	}
    
	@GetMapping("/")
	public List<Stagiaire> findAll() {
		return stagiaireService.findAll();
	}

	@GetMapping("/find/nom/{nom}")
	public Stagiaire findByNom(@PathVariable String nom) {
		return stagiaireService.findByNom(nom);
	}

	@GetMapping("/find/id/{id}")
	public Optional<Stagiaire> findById(@PathVariable Long id) {
		return stagiaireService.findById(id);
	}

	@Transactional
	@DeleteMapping("/delete/id/{id}")
	public void deleteById(@PathVariable Long id) {
		stagiaireService.deleteById(id);
	}
	
	@PutMapping("/update/{id}")
    public Stagiaire updateStagiaire(@PathVariable(value = "id") Long stagiaireId,
         @Valid @RequestBody Stagiaire stagiaireDetails) {
       return stagiaireService.updateStagiaire(stagiaireId, stagiaireDetails);
    }
	
	@PutMapping("/update/")
	public int update(@RequestBody Stagiaire stagiaire) {
		return stagiaireService.update(stagiaire);
	}
}
