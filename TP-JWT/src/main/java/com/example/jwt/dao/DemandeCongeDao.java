package com.example.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jwt.bean.DemandeConge;

@Repository
public interface DemandeCongeDao extends JpaRepository<DemandeConge, Long> {

}
