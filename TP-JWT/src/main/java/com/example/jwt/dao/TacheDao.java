package com.example.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.jwt.bean.Tache;
@Repository
public interface TacheDao extends JpaRepository<Tache, Long> {
	
	public Tache findByProjetAndIdNot(String projet,Long id);
	/*
	 * public Long getId() { return id; } public void setId(Long id) { this.id = id;
	 * } public String getProjet() { return projet; }
	 */

}
