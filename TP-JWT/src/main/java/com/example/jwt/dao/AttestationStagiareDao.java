package com.example.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.jwt.bean.AttestationStagiaire;
import com.example.jwt.bean.Stagiaire;

@Repository
public interface AttestationStagiareDao extends JpaRepository<AttestationStagiaire, Long> {

	 public AttestationStagiaire findByStagiaire(Stagiaire stagiaire);

	 public void deleteById(Long id);
	 
	 @Query("SELECT s.encadrent,e.dateDebut,e.dateFin,e.stagiaire FROM Stage s JOIN s.equipeItems e WHERE e.stagiaire.nom = :nom")
	 public Object findStageAndEquipeItemAndStagiaireByNom(@Param("nom") String nom);
}
