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

import com.example.jwt.bean.Holiday;
import com.example.jwt.service.HolidayImpl;

@RestController
@RequestMapping("/tp-jwt/holiday")
@CrossOrigin(origins = "http://localhost:4200")
public class HolidayRest {
	
	@Autowired
	private HolidayImpl holidayImpl;

	@PostMapping("/")
	public Holiday save(@RequestBody Holiday holiday) {
		return holidayImpl.save(holiday);
	}

	@GetMapping("/")
	public List<Holiday> findAll() {
		return holidayImpl.findAll();
	}

	@Transactional
	@DeleteMapping("/id/{id}")
	public int deleteById(@PathVariable Long id) {
		return holidayImpl.deleteById(id);
	}

	@PutMapping("/update/")
	public int update(@RequestBody Holiday holiday) {
		return holidayImpl.update(holiday);
	}
	
	

}
