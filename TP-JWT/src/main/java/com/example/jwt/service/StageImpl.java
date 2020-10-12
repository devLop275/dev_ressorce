package com.example.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.jwt.bean.EquipeItem;
import com.example.jwt.bean.Stage;
import com.example.jwt.dao.EquipeItemDao;
import com.example.jwt.dao.StageDao;

@Service
public class StageImpl {
	
	@Autowired
	private StageDao stageDao;
	
	@Autowired
	private EquipeItemImpl equipeService;

	public Stage save(Stage stage) {
		return stageDao.save(stage);
	}

	public List<Stage> findAll() {
		return stageDao.findAll();
	}
	
	public void deleteById(Long id) {
	   stageDao.deleteById(id);
	}
	
	public int nbStage() {
		return stageDao.nbStage();
	}
    
	public Stage updateStage(Long stageId,Stage stageDetails) {
        Stage stage = stageDao.getOne(stageId);
        stage.setRaison(stageDetails.getRaison());
        stage.setEtat(stageDetails.getEtat());
        stage.setEncadrent(stage.getEncadrent());
        final Stage updatedStage = stageDao.save(stage);
        return updatedStage;
    }
	
	public int saveWithEquipeItems(Stage stage) {

		if (stage == null) {
			return -1;
		} else {
			if (stage.getEquipeItems().isEmpty()) {
				return -2;
			} else {
				stageDao.save(stage);
				for (EquipeItem equipeItem : stage.getEquipeItems()) {
					equipeItem.setStage(stage);
					equipeService.save(equipeItem);
				}
				return 1;
			}
		}
	}
	
}
