package com.example.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jwt.bean.Departement;

@Repository
public interface DepartementDao extends JpaRepository<Departement, Long> {

	public void deleteById(Long id);
	
	public Departement findByLibelleAndIdNot(String libelle, Long id);
}
