package com.example.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.jwt.bean.TypeAttestation;

@Repository
public interface TypeAttestationDao extends JpaRepository<TypeAttestation, Long> {

	public TypeAttestation findByLibelle(String libelle);

	 public void deleteById(Long id);
}
