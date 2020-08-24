package com.example.jwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.jwt.bean.Employee;
import com.example.jwt.bean.Stagiaire;
import com.example.jwt.dao.StagiaireDao;

@Service
public class StagiaireImpl {

	@Autowired
	private StagiaireDao stagiaireDao;

	public Stagiaire save(Stagiaire stagiaire) {
		return stagiaireDao.save(stagiaire);
	}

	public List<Stagiaire> findAll() {
		return stagiaireDao.findAll();
	}

	public Stagiaire findByNom(String nom) {
		return stagiaireDao.findByNom(nom);
	}

	public void deleteById(Long id) {
		stagiaireDao.deleteById(id);
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

	public Optional<Stagiaire> findById(Long id) {
		return stagiaireDao.findById(id);
	}
	
	
}
