package com.example.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jwt.bean.AttestationEmployee;
import com.example.jwt.bean.Employee;
import com.example.jwt.dao.AttestationEmployeeDao;

@Service
public class AttestationEmployeeImpl {

	@Autowired
	private AttestationEmployeeDao attestationEmployeeDao;

	public AttestationEmployee save(AttestationEmployee attestationEmployee) {
		return attestationEmployeeDao.save(attestationEmployee);
	}

	public List<AttestationEmployee> findAll() {
		return attestationEmployeeDao.findAll();
	}

	public AttestationEmployee findByEmployee(Employee employee) {
		return attestationEmployeeDao.findByEmployee(employee);
	}

	public void deleteById(Long id) {
		attestationEmployeeDao.deleteById(id);
	}
	
	
}
