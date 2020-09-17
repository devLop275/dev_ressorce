package com.example.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jwt.bean.Departement;
import com.example.jwt.dao.DepartementDao;

@Service
public class DepartementImpl {

	@Autowired
	private DepartementDao departementDao;

	public Departement save(Departement departement) {
		return departementDao.save(departement);
	}

	public List<Departement> findAll() {
		return departementDao.findAll();
	}
	
	public int deleteById(Long id) {
		if(id == null) {
			return -1;
		} else {
			departementDao.deleteById(id);
			return 1;
		}
	}
	
	public int update(Departement departement) {
		if(departementDao.findByLibelleAndIdNot(departement.getLibelle(), departement.getId()) != null) {
			return -1;
		} else {
			departementDao.save(departement);
			return 1;
		}
	}
	
}
