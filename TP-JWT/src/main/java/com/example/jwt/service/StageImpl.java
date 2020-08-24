package com.example.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.jwt.bean.Stage;
import com.example.jwt.bean.Stagiaire;
import com.example.jwt.dao.StageDao;

@Service
public class StageImpl {
	
	@Autowired
	private StageDao stageDao;

	public Stage save(Stage stage) {
		return stageDao.save(stage);
	}

	public List<Stage> findAll() {
		return stageDao.findAll();
	}
	
	public void deleteById(Long id) {
	   stageDao.deleteById(id);
	}
    
	public Stage updateStage(Long stageId,Stage stageDetails) {
        Stage stage = stageDao.getOne(stageId);
        stage.setRaison(stageDetails.getRaison());
        stage.setEtat(stageDetails.getEtat());
        stage.setEncadrent(stage.getEncadrent());
        final Stage updatedStage = stageDao.save(stage);
        return updatedStage;
    }
	
}
