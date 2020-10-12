package com.example.jwt.rest;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.jwt.bean.DemandeConge;
import com.example.jwt.service.DemandeCongeImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@RestController
@RequestMapping("/tp-jwt/demandeConge")
@CrossOrigin(origins = "http://localhost:4200")
public class DemandeCongeRest {

	@Autowired
	private DemandeCongeImpl demandeCongeImpl;

	
	//public DemandeConge save(@RequestBody DemandeConge demandeConge,@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		
		//return demandeCongeImpl.save(demandeConge,file);
	//}
	
	/*
	 * @PostMapping("/") public DemandeConge save(@RequestBody DemandeConge
	 * demandeConge, @RequestParam("file") MultipartFile file) { return
	 * demandeCongeImpl.save(demandeConge, file); }
	 */

	//public DemandeConge save(@RequestBody DemandeConge demandeConge) {
		//return demandeCongeImpl.save(demandeConge);
	//}
	
	@PostMapping("/") 
	public DemandeConge save(@RequestPart("demandeConge") String demandeConge,@RequestPart("file") MultipartFile file) throws JsonMappingException, JsonProcessingException {
		DemandeConge newDemandeConge = new ObjectMapper().readValue(demandeConge, DemandeConge.class);
		return demandeCongeImpl.save(newDemandeConge,file);
	}
	
	@GetMapping("/download/{fileName:.+}")
	public ResponseEntity<Resource> downloadFileFromLocal(@PathVariable String fileName) {
		Path path = Paths.get("uploads/" + fileName);
		Resource resource = null;
		try {
			resource = new UrlResource(path.toUri());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}

	@GetMapping("/")
	public List<DemandeConge> findAll() {
		return demandeCongeImpl.findAll();
	}
	
	@GetMapping("/count/")
	public int nbConges() {
		return demandeCongeImpl.nbConges();
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
