package com.example.jwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.jwt.bean.Employee;
import com.example.jwt.bean.Stagiaire;
import com.example.jwt.dao.StagiaireDao;

@Service
public class StagiaireImpl {

	@Autowired
	private StagiaireDao stagiaireDao;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public Stagiaire save(Stagiaire stagiaire) {
		stagiaire.setPassword(passwordEncoder.encode(stagiaire.getPassword()));
		return stagiaireDao.save(stagiaire);
	}

	public List<Stagiaire> findAll() {
		return stagiaireDao.findAll();
	}

	public Stagiaire findByNom(String nom) {
		return stagiaireDao.findByNom(nom);
	}

	public int deleteById(Long id) {
		if(id == null) {
			return -1;
		}
		else {
			stagiaireDao.deleteById(id);
			return 1;
		}
	}
	
	public Stagiaire updateStagiaire(Long employeeId,Stagiaire stagiaireDetails) {
        Stagiaire stagiaire = stagiaireDao.getOne(employeeId);
        stagiaire.setNom(stagiaireDetails.getNom());
        stagiaire.setPrenom(stagiaireDetails.getPrenom());
        stagiaire.setEmail(stagiaireDetails.getEmail());
        stagiaire.setAdresse(stagiaireDetails.getAdresse());
        stagiaire.setVille(stagiaireDetails.getVille());
        final Stagiaire updatedStagiaire = stagiaireDao.save(stagiaire);
        return updatedStagiaire;
    }
	
	public int update(Stagiaire stagiaire) {
		// if the product is already in the table and its not the product who will be updated
		if (stagiaireDao.findByNomAndIdNot(stagiaire.getNom(), stagiaire.getId()) != null) {
			return -1;
		} else {
			stagiaireDao.save(stagiaire);
			return 1;
		}
	}

	public Optional<Stagiaire> findById(Long id) {
		return stagiaireDao.findById(id);
	}
	
	public int nbStagiaire() {
		return stagiaireDao.nbStagiaire();
	}
	
	
}
