package com.example.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jwt.bean.EquipeItem;
import com.example.jwt.bean.Stagiaire;

@Repository
public interface EquipeItemDao extends JpaRepository<EquipeItem, Long> {

	 public EquipeItem findByStagiaire(Stagiaire stagiaire);

	 public void deleteById(Long id);
}
