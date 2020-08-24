package com.example.jwt.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jwt.bean.Stage;

@Repository
public interface StageDao extends JpaRepository<Stage, Long> {

	public void deleteById(Long id);
	

}
