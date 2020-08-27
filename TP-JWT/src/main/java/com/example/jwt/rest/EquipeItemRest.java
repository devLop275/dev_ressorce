package com.example.jwt.rest;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt.bean.Employee;
import com.example.jwt.bean.EquipeItem;
import com.example.jwt.bean.Stagiaire;
import com.example.jwt.service.EquipeItemImpl;

@RestController
@RequestMapping("/tp-jwt/equipeItem")
@CrossOrigin(origins = "http://localhost:4200")
public class EquipeItemRest {

	@Autowired 
	private EquipeItemImpl equipeItemImpl;

	@PostMapping("/")
	public EquipeItem save(@RequestBody EquipeItem equipeItem) {
		return equipeItemImpl.save(equipeItem);
	}

	@GetMapping("/")
	public List<EquipeItem> findAll() {
		return equipeItemImpl.findAll();
	}

	@GetMapping("/find/")
	public EquipeItem findByStagiaire(Stagiaire stagiaire) {
		return equipeItemImpl.findByStagiaire(stagiaire);
	}

	@Transactional
	@DeleteMapping("/delete/id/{id}")
	public void deleteById(@PathVariable Long id) {
		 equipeItemImpl.deleteById(id);
	}
	
	@PutMapping("/update/")
	public int update(@RequestBody EquipeItem equipeItem) {
		return equipeItemImpl.update(equipeItem);
	}
	
}
