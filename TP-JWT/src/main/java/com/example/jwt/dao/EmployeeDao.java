package com.example.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jwt.bean.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {

	public Employee findByNom(String nom);
	
	public Employee findByNomAndIdNot(String nom,Long id);
	
}
