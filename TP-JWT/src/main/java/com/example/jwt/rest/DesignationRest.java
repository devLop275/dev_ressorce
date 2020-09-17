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

import com.example.jwt.bean.Designation;
import com.example.jwt.service.DesignationImpl;

@RestController
@RequestMapping("/tp-jwt/designation")
@CrossOrigin(origins = "http://localhost:4200")
public class DesignationRest {
	
	@Autowired
	private DesignationImpl designationImpl;

	@PostMapping("/")
	public Designation save(@RequestBody Designation designation) {
		return designationImpl.save(designation);
	}

	@GetMapping("/")
	public List<Designation> findAll() {
		return designationImpl.findAll();
	}
	
	@Transactional
	@DeleteMapping("/delete/id/{id}")
	public int deleteById(@PathVariable Long id) {
		return designationImpl.deleteById(id);
	}

	@PutMapping("/update/")
	public int update(@RequestBody Designation designation) {
		return designationImpl.update(designation);
	}
	
	

}
