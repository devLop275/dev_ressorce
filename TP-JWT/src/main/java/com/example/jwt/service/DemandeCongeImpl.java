package com.example.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jwt.bean.DemandeConge;
import com.example.jwt.dao.DemandeCongeDao;

@Service
public class DemandeCongeImpl {

	@Autowired
	private DemandeCongeDao demandeCongeDao;

	public DemandeConge save(DemandeConge demandeConge) {
		return demandeCongeDao.save(demandeConge);
	}

	public List<DemandeConge> findAll() {
		return demandeCongeDao.findAll();
	}
	
	
}
