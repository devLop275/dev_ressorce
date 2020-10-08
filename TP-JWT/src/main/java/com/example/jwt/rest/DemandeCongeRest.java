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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.jwt.bean.DemandeConge;
import com.example.jwt.service.DemandeCongeImpl;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
@RestController
@RequestMapping("/tp-jwt/demandeConge")
@CrossOrigin(origins = "http://localhost:4200")
public class DemandeCongeRest {

	@Autowired
	private DemandeCongeImpl demandeCongeImpl;

	


	/*
	 * @PostMapping("/") public DemandeConge save(@RequestBody DemandeConge
	 * demandeConge,@RequestParam("file") MultipartFile file) throws
	 * JsonParseException , JsonMappingException , Exception { return
	 * demandeCongeImpl.save(demandeConge, file); }
	 */



	//@PostMapping("/")
	//public DemandeConge save(@RequestBody DemandeConge demandeConge) {
		//return demandeCongeImpl.save(demandeConge);
	//}

	
	
	
	@GetMapping("/")
	public List<DemandeConge> findAll() {
		return demandeCongeImpl.findAll();
	}
	

    @PostMapping("/")
    public DemandeConge save(@RequestBody DemandeConge demandeConge,@RequestParam("file") MultipartFile file) throws JsonParseException, JsonMappingException, Exception {
		return demandeCongeImpl.save(demandeConge);
	}


	@Transactional
	@DeleteMapping("/delete/id/{id}")
	public int delete(@PathVariable Long id) {
		return demandeCongeImpl.deleteById(id);
	}
	
	


	@PutMapping("/update/")
	public int update(@RequestBody DemandeConge demandeConge) {
		return demandeCongeImpl.update(demandeConge);
	}
}
