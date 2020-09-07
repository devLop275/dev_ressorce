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
	
	public int deleteById(Long id) {
		if(id == null) {
			return -1;
		}else {
			//typeCongeDao.delete(typeConge);
			demandeCongeDao.deleteById(id);
			return 1;
		}
	}
	
	public int update(DemandeConge demandeConge) {
		if(demandeCongeDao.findByDureeAndIdNot(demandeConge.getDuree(), demandeConge.getId()) != null ) {
			return -1;
		} else {
			demandeCongeDao.save(demandeConge);
			return 1;
		}
	}
}
