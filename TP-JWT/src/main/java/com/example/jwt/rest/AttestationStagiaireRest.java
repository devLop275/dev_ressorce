package com.example.jwt.rest;

import java.io.FileNotFoundException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt.bean.AttestationStagiaire;
import com.example.jwt.bean.Stagiaire;
import com.example.jwt.dao.AttestationStagiareDao;
import com.example.jwt.service.AttestationStagiaireImpl;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/tp-jwt/attestationSt")
@CrossOrigin(origins = "http://localhost:4200")
public class AttestationStagiaireRest {

	@Autowired
	private AttestationStagiareDao attestationStagiaireDao;
	@Autowired
	private AttestationStagiaireImpl attestationStagiaireService;

	@PostMapping("/")
	public AttestationStagiaire save(@RequestBody AttestationStagiaire attestationStagiare) {
		return attestationStagiaireDao.save(attestationStagiare);
	}

	@GetMapping("/")
	public List<AttestationStagiaire> findAll() {
		return attestationStagiaireDao.findAll();
	}

	@GetMapping("/find/")
	public AttestationStagiaire findByStagiaire(Stagiaire stagiaire) {
		return attestationStagiaireDao.findByStagiaire(stagiaire);
	}

	@GetMapping("/find/nom/{nom}")
	public Object findStageAndEquipeItemAndStagiaireByNom(@PathVariable String nom) {
		return attestationStagiaireService.findStageAndEquipeItemAndStagiaireByNom(nom);
	}

	@Transactional
	@DeleteMapping("/delete/id/{id}")
	public void deleteById(@PathVariable Long id) {
		attestationStagiaireDao.deleteById(id);
	}

	@GetMapping("/report/{format}/nom/{nom}")
	public String generateReport(@PathVariable String format, @PathVariable String nom)
			throws FileNotFoundException, JRException {
		return attestationStagiaireService.exportReport(format, nom);
	}

}
