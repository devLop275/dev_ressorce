package com.example.jwt.rest;

import java.io.FileNotFoundException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt.bean.AttestationEmployee;
import com.example.jwt.bean.Employee;
import com.example.jwt.dao.AttestationEmployeeDao;
import com.example.jwt.service.AttestationEmployeeImpl;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/tp-jwt/attestationEm")
@CrossOrigin(origins = "http://localhost:4200")
public class AttestationEmployeeRest {

	@Autowired
	private AttestationEmployeeDao attestationEmployeeDao;
	
	@Autowired
	private AttestationEmployeeImpl attestationService;
    
	@PostMapping("/")
	public AttestationEmployee save(AttestationEmployee attestationEmployee) {
		return attestationEmployeeDao.save(attestationEmployee);
	}

	@GetMapping("/")
	public List<AttestationEmployee> findAll() {
		return attestationEmployeeDao.findAll();
	}

	@GetMapping("/find/")
	public AttestationEmployee findByEmployee(Employee employee) {
		return attestationEmployeeDao.findByEmployee(employee);
	}

	@Transactional
	@DeleteMapping("/delete/id/{id}")
	public void deleteById(@PathVariable Long id) {
		 attestationEmployeeDao.deleteById(id);
	}

	@GetMapping("/report/{format}/nom/{nom}")
    public String generateReport(@PathVariable String format,@PathVariable String nom) throws FileNotFoundException, JRException {
        return attestationService.exportReport(format,nom);
    }
   
}

