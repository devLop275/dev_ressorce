package com.example.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jwt.bean.Employee;
import com.example.jwt.bean.EquipeItem;
import com.example.jwt.bean.Stagiaire;
import com.example.jwt.dao.EquipeItemDao;

@Service
public class EquipeItemImpl {

	@Autowired
	private EquipeItemDao equipeItemDao;

	public EquipeItem findByStagiaire(Stagiaire stagiaire) {
		return equipeItemDao.findByStagiaire(stagiaire);
	}

	public void deleteById(Long id) {
		equipeItemDao.deleteById(id);
	}

	public EquipeItem save(EquipeItem equipeItem) {
		return equipeItemDao.save(equipeItem);
	}

	public List<EquipeItem> findAll() {
		return equipeItemDao.findAll();
	}

	
  public int update(EquipeItem equipeItem) {
	  if(equipeItemDao.findByDateDebutAndIdNot(equipeItem.getDateDebut(), equipeItem.getId()) != null) {
		  return -1;
	  } else {
		  equipeItemDao.save(equipeItem);
		  return 1;
	  }
  }
	
}
