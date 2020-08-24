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

import com.example.jwt.bean.Employee;
import com.example.jwt.dao.EmployeeDao;
import com.example.jwt.service.EmployeeImpl;

@RestController
@RequestMapping("/tp-jwt/employee")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeRest {

	@Autowired
	private EmployeeImpl employeeService;

	@PostMapping("/")
	public Employee save(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}

	@GetMapping("/")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	@GetMapping("/find/nom/{nom}")
	public Employee findByNom(@PathVariable String nom) {
		return employeeService.findByNom(nom);
	}

	@Transactional
	@DeleteMapping("/delete/id/{id}")
	public int deleteById(@PathVariable Long id) {
		return employeeService.deleteById(id);
	}
	
	@Transactional
	@DeleteMapping("/delete/")
	public int delete(Employee employee) {
		return employeeService.delete(employee);
	}
	
	@PutMapping("/update/id/{id}")
    public Employee updateEmployee(@PathVariable(value = "id") Long employeeId,
         @Valid @RequestBody Employee employeeDetails) {
       return employeeService.updateEmployee(employeeId, employeeDetails);
    }
	
	@PutMapping("/update/")
	public int update(@RequestBody Employee employee) {
		return employeeService.update(employee);
	}
	
	
}
