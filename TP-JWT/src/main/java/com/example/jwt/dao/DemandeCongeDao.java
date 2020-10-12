package com.example.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.example.jwt.bean.DemandeConge;


@Repository
public interface DemandeCongeDao extends JpaRepository<DemandeConge, Long> {

    public void deleteById(Long id);
	
	public DemandeConge findByDureeAndIdNot(int duree,Long id);
	
	@Query("SELECT COUNT(c) FROM DemandeConge c")
	public int nbConges();

}
