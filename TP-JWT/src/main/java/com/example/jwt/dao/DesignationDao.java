package com.example.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jwt.bean.Designation;

@Repository
public interface DesignationDao extends JpaRepository<Designation, Long> {
  
	public void deleteById(Long id);
	
	public Designation findByLibelleAndIdNot(String libelle, Long id);
	
}
