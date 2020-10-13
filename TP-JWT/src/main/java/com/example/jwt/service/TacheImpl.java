package com.example.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jwt.bean.Tache;
import com.example.jwt.dao.TacheDao;

@Service
public class TacheImpl {
	
	@Autowired
	private TacheDao tacheDao;

	public Tache save(Tache tache) {
		return tacheDao.save(tache);
	}

	public List<Tache> findAll() {
		return tacheDao.findAll();
	}
	
	public int deleteByID(Long id) {
		if(id == null) {
			return -1;
		} else {
			tacheDao.deleteById(id);
			return 1;
		}
	}
	
	public int update(Tache tache) {
		if(tacheDao.findByProjetAndIdNot(tache.getProjet(),tache.getId()) != null){
			return -1;
		} else {
			tacheDao.save(tache);
			return 1;
		}
	}
	

}
