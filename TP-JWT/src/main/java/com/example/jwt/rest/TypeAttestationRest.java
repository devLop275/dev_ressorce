package com.example.jwt.rest;

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

import com.example.jwt.bean.TypeAttestation;
import com.example.jwt.dao.TypeAttestationDao;

@RestController
@RequestMapping("/tp-jwt/typeAttestation")
@CrossOrigin(origins = "http://localhost:4200")
public class TypeAttestationRest {

	@Autowired
	private TypeAttestationDao attestationDao;

	@PostMapping("/")
	public TypeAttestation save(@RequestBody TypeAttestation typeAttestation) {
		return attestationDao.save(typeAttestation);
	}
    @GetMapping("/")
	public List<TypeAttestation> findAll() {
		return attestationDao.findAll();
	}
    
    @GetMapping("/find/libelle/{libelle}")
	public TypeAttestation findByLibelle(@PathVariable String libelle) {
		return attestationDao.findByLibelle(libelle);
	}
	
	@Transactional
	@DeleteMapping("/delete/id/{id}")
	public void deleteById(@PathVariable Long id) {
		 attestationDao.deleteById(id);
	}

    
}

