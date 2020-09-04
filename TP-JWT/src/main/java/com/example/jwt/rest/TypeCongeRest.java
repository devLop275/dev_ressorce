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
import com.example.jwt.bean.TypeConge;
import com.example.jwt.service.TypeCongeImpl;

@RestController
@RequestMapping("/tp-jwt/typeConge")
@CrossOrigin(origins = "http://localhost:4200")
public class TypeCongeRest {
	
	@Autowired
	private TypeCongeImpl typeCongeImpl;

	@PostMapping("/")
	public TypeConge save(@RequestBody TypeConge typeConge) {
		return typeCongeImpl.save(typeConge);
	}

	@GetMapping("/")
	public List<TypeConge> findAll() {
		return typeCongeImpl.findAll();
	}

	@Transactional
	@DeleteMapping("/delete/id/{id}")
	public int delete(@PathVariable Long id) {
		return typeCongeImpl.deleteById(id);
	}
	
	@PutMapping("/update/")
	public int update(@RequestBody TypeConge typeConge) {
		return typeCongeImpl.update(typeConge);
	}
	

}
