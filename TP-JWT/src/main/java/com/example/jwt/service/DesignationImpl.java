package com.example.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jwt.bean.Designation;
import com.example.jwt.dao.DesignationDao;

@Service
public class DesignationImpl {

	@Autowired
	private DesignationDao designationDao;

	public Designation save(Designation designation) {
		return designationDao.save(designation);
	}

	public List<Designation> findAll() {
		return designationDao.findAll();
	}
	
	public int deleteById(Long id) {
		if(id == null) {
			return -1;
		} else {
			designationDao.deleteById(id);
			return 1;
		}
	}
	
	public int update(Designation designation) {
		if(designationDao.findByLibelleAndIdNot(designation.getLibelle(), designation.getId()) != null) {
			return -1;
		} else {
			designationDao.save(designation);
			return 1;
		}
	}
}
