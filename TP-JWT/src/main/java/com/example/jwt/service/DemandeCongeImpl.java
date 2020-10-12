package com.example.jwt.service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.jwt.bean.DemandeConge;
import com.example.jwt.dao.DemandeCongeDao;

@Service
public class DemandeCongeImpl {

	@Autowired
	private DemandeCongeDao demandeCongeDao;

	private final Path root = Paths.get("uploads");

	public void init() {
		try {
			Files.createDirectory(root);
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize folder for upload!");
		}
	}
	
	public Resource load(String filename) {
	    try {
	      Path file = root.resolve(filename);
	      Resource resource = new UrlResource(file.toUri());

	      if (resource.exists() || resource.isReadable()) {
	        return resource;
	      } else {
	        throw new RuntimeException("Could not read the file!");
	      }
	    } catch (MalformedURLException e) {
	      throw new RuntimeException("Error: " + e.getMessage());
	    }
	  }

	public List<DemandeConge> findAll() {
		return demandeCongeDao.findAll();
	}

	public int deleteById(Long id) {
		if (id == null) {
			return -1;
		} else {
			// typeCongeDao.delete(typeConge);
			demandeCongeDao.deleteById(id);
			return 1;
		}
	}

	public int nbConges() {
		return demandeCongeDao.nbConges();
	}

	public int update(DemandeConge demandeConge) {
		if (demandeCongeDao.findByDureeAndIdNot(demandeConge.getDuree(), demandeConge.getId()) != null) {
			return -1;
		} else {
			demandeCongeDao.save(demandeConge);
			return 1;
		}
	}

	/*
	 * public DemandeConge save(DemandeConge demandeConge,MultipartFile file) {
	 * if(demandeConge.getCertificat().isEmpty()) {
	 * //redirectAttributes.addFlashAttribute("message",
	 * "Please select a file to upload"); return demandeCongeDao.save(demandeConge);
	 * } else { try {
	 * 
	 * byte[] bytes = file.getBytes(); Path path = Paths.get(
	 * "C:\\Users\\HP\\git\\dev_ressorce\\TP-JWT\\src\\main\\resources\\uploads\\" +
	 * file.getOriginalFilename()); Files.write(path, bytes);
	 * demandeCongeDao.save(demandeConge);
	 * 
	 * //redirectAttributes.addFlashAttribute(
	 * "message","You successfully uploaded '" + file.getOriginalFilename() + "'");
	 * 
	 * } catch (IOException e) { e.printStackTrace();
	 * 
	 * } return demandeCongeDao.save(demandeConge); }
	 * 
	 * }
	 */

	public DemandeConge save(DemandeConge demandeConge, MultipartFile file) {
		try {
			Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
		} catch (Exception e) {
			throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		}
		if (file != null) {
			demandeConge.setNomCertificat(file.getOriginalFilename());
		}
		return demandeCongeDao.save(demandeConge);
	}

}
