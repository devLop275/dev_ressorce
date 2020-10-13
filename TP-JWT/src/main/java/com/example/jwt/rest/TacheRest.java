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

import com.example.jwt.bean.Tache;
import com.example.jwt.service.TacheImpl;

@RestController
@RequestMapping("/tp-jwt/tache")
@CrossOrigin(origins = "http://localhost:4200")
public class TacheRest {

	@Autowired
	private TacheImpl tacheImpl;

	@PostMapping("/")
	public Tache save( @RequestBody Tache tache) {
		return tacheImpl.save(tache);
	}

	@GetMapping("/")
	public List<Tache> findAll() {
		return tacheImpl.findAll();
	}

	@Transactional
	@DeleteMapping("/id/{id)")
	public int deleteByID(@PathVariable Long id) {
		return tacheImpl.deleteByID(id);
	}

	@PutMapping("/update/")
	public int update(@RequestBody Tache tache) {
		return tacheImpl.update(tache);
	}
	
	
}
