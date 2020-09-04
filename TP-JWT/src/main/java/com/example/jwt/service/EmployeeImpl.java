package com.example.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.jwt.bean.Employee;
import com.example.jwt.dao.EmployeeDao;

@Service
public class EmployeeImpl {

	@Autowired
	private EmployeeDao employeeDao;

	public Employee save(Employee employee) {
		return employeeDao.save(employee);
	}

	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	public Employee findByNom(String nom) {
		return employeeDao.findByNom(nom);
	}

	public int deleteById(Long id) {
		if(id==null) {
			return -1;
		}else {
			employeeDao.deleteById(id);
			return 1;
		}
	}
	
	public int delete(Employee employee) {
		if(employee == null) {
			return -1;
		}else {
			employeeDao.delete(employee);
			return 1;
		}
	}

	
	
	public Employee updateEmployee(Long employeeId,Employee employeeDetails) {
        Employee employee = employeeDao.getOne(employeeId);
        employee.setNom(employeeDetails.getNom());
        employee.setPrenom(employeeDetails.getPrenom());
        employee.setEmail(employeeDetails.getEmail());
        employee.setAdresse(employeeDetails.getAdresse());
        employee.setVille(employeeDetails.getVille());
        final Employee updatedEmployee = employeeDao.save(employee);
        return updatedEmployee;
    }
	
	//public void deleteById(Long id) {
		//employeeDao.deleteById(id);
	//}

	public int update(Employee employee) {
		// if the product is already in the table and its not the product who will be updated
		if (employeeDao.findByNomAndIdNot(employee.getNom(), employee.getId()) != null) {
			return -1;
		} else {
			employeeDao.save(employee);
			return 1;
		}
	}

	
}
