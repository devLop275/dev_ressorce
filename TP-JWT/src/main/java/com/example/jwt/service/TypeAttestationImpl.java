package com.example.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jwt.bean.TypeAttestation;
import com.example.jwt.dao.TypeAttestationDao;

@Service
public class TypeAttestationImpl {
	
	@Autowired
	private TypeAttestationDao attestationDao;

	public TypeAttestation save(TypeAttestation typeAttestation) {
		return attestationDao.save(typeAttestation);
	}

	public List<TypeAttestation> findAll() {
		return attestationDao.findAll();
	}

	public TypeAttestation findByLibelle(String libelle) {
		return attestationDao.findByLibelle(libelle);
	}

	public void deleteById(Long id) {
		 attestationDao.deleteById(id);
	}

	
	
}
