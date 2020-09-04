package com.example.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jwt.bean.Employee;
import com.example.jwt.bean.TypeConge;
import com.example.jwt.dao.TypeCongeDao;

@Service
public class TypeCongeImpl {

	@Autowired
	private TypeCongeDao typeCongeDao;

	public TypeConge save(TypeConge typeConge) {
		return typeCongeDao.save(typeConge);
	}

	public List<TypeConge> findAll() {
		return typeCongeDao.findAll();
	}
	
	public int deleteById(Long id) {
		if(id == null) {
			return -1;
		}else {
			//typeCongeDao.delete(typeConge);
			typeCongeDao.deleteById(id);
			return 1;
		}
	}
	
	public int update(TypeConge typeConge) {
		if(typeCongeDao.findByLibelleAndIdNot(typeConge.getLibelle(), typeConge.getId()) != null ) {
			return -1;
		} else {
			typeCongeDao.save(typeConge);
			return 1;
		}
	}
}
