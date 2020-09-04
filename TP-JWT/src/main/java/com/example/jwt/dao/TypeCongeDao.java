package com.example.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jwt.bean.Stagiaire;
import com.example.jwt.bean.TypeConge;

@Repository
public interface TypeCongeDao extends JpaRepository<TypeConge, Long> {

	public void deleteById(Long id);
	
	public TypeConge findByLibelleAndIdNot(String libelle,Long id);
}
