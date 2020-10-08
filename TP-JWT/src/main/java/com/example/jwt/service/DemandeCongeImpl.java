package com.example.jwt.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.jwt.bean.DemandeConge;
import com.example.jwt.dao.DemandeCongeDao;

@Service
public class DemandeCongeImpl {

	@Autowired
	private DemandeCongeDao demandeCongeDao;

	
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
	
	public DemandeConge save(DemandeConge demandeConge) {
		return demandeCongeDao.save(demandeConge);
	}

	
}
