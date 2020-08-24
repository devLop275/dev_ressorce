package com.example.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.jwt.bean.AttestationStagiaire;
import com.example.jwt.bean.Stagiaire;

@Repository
public interface AttestationStagiareDao extends JpaRepository<AttestationStagiaire, Long> {

	 public AttestationStagiaire findByStagiaire(Stagiaire stagiaire);

	 public void deleteById(Long id);
}
