package com.example.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.jwt.bean.Stagiaire;

@Repository
public interface StagiaireDao extends JpaRepository<Stagiaire, Long> {

	public Stagiaire findByNom(String nom);

	public void deleteById(Long id);
}
