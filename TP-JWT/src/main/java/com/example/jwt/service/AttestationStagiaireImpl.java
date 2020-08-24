package com.example.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jwt.bean.AttestationStagiaire;
import com.example.jwt.bean.Stagiaire;
import com.example.jwt.dao.AttestationStagiareDao;

@Service
public class AttestationStagiaireImpl {

	@Autowired
	private AttestationStagiareDao attestationStagiareDao;

	public AttestationStagiaire save(AttestationStagiaire attestationStagiaire) {
		return attestationStagiareDao.save(attestationStagiaire);
	}

	public List<AttestationStagiaire> findAll() {
		return attestationStagiareDao.findAll();
	}

	
	public AttestationStagiaire findByStagiaire(Stagiaire stagiaire) {
		return attestationStagiareDao.findByStagiaire(stagiaire);
	}

	public void deleteById(Long id) {
		attestationStagiareDao.deleteById(id);
	}
	
	
}
