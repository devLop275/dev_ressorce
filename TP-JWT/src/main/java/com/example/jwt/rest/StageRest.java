package com.example.jwt.rest;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt.bean.Stage;
import com.example.jwt.bean.Stagiaire;
import com.example.jwt.dao.StageDao;
import com.example.jwt.service.StageImpl;

@RestController
@RequestMapping("/tp-jwt/stage")
@CrossOrigin(origins = "http://localhost:4200")
public class StageRest {

	@Autowired
	private StageImpl stageService;

	@PostMapping("/stage/")
	public Stage save(@RequestBody Stage stage) {
		return stageService.save(stage);
	}

	@GetMapping("/")
	public List<Stage> findAll() {
		return stageService.findAll();
	}
	
	@GetMapping("/count/")
	public int nbStage() {
		return stageService.nbStage();
	}
	
	@PostMapping("/")
	public int saveWithEquipeItems(@RequestBody Stage stage) {
		return stageService.saveWithEquipeItems(stage);
	}

	@Transactional
	@DeleteMapping("/delete/id/{id}")
	public void deleteById(Long id) {
		stageService.deleteById(id);
	}
	
	@PutMapping("/update/{id}")
    public Stage updateStage(@PathVariable(value = "id") Long stageId,
         @Valid @RequestBody Stage stageDetails) {
       return stageService.updateStage(stageId, stageDetails);
    }
    
	
}
