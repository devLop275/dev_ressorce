package com.example.jwt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.jwt.bean.AttestationStagiaire;
import com.example.jwt.bean.Stagiaire;

@Repository
public interface AttestationStagiareDao extends JpaRepository<AttestationStagiaire, Long> {

	 //public AttestationStagiaire findByStagiaire(Stagiaire stagiaire);

	 public void deleteById(Long id);
	 
	 @Query("SELECT NEW com.example.jwt.bean.AttestationStagiaire(s.encadrent.nom,s.encadrent.prenom,e.dateDebut,e.dateFin,e.stagiaire.nom,e.stagiaire.prenom,e.stagiaire.departement.libelle,e.stagiaire.designation.libelle) FROM Stage s JOIN s.equipeItems e WHERE e.stagiaire.nom = :nom")
	 public AttestationStagiaire findStageAndEquipeItemAndStagiaireByNom(@Param("nom") String nom);
	 
	 @Query("SELECT s FROM EquipeItem e JOIN e.stagiaire s")
	 public List<Stagiaire> findStagiaireAndEquipeItem();
}
