package com.example.jwt.service;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.jwt.bean.DemandeConge;
import com.example.jwt.dao.DemandeCongeDao;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class DemandeCongeImpl {

	@Autowired
	private DemandeCongeDao demandeCongeDao;

	@Autowired
	private ServletContext context;

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

	/*
	 * public DemandeConge save(DemandeConge demandeConge, MultipartFile file,
	 * RedirectAttributes redirectAttributes) throws JsonParseException,
	 * JsonMappingException, Exception { if (demandeConge.getCertificat().isEmpty())
	 * { redirectAttributes.addFlashAttribute("message",
	 * "Please select a file to upload"); return demandeCongeDao.save(demandeConge);
	 * } else { try {
	 * 
	 * byte[] bytes = file.getBytes(); Path path = Paths.get(
	 * "C:\\Users\\HP\\git\\dev_ressorce\\TP-JWT\\src\\main\\resources\\uploads\\" +
	 * file.getOriginalFilename()); Files.write(path, bytes);
	 * 
	 * redirectAttributes.addFlashAttribute("message", "You successfully uploaded '"
	 * + file.getOriginalFilename() + "'");
	 * 
	 * } catch (IOException e) { e.printStackTrace();
	 * 
	 * }
	 * 
	 * demandeConge.setCertificat("done"); return
	 * demandeCongeDao.save(demandeConge); }
	 * 
	 * }
	 */

	/*
	 * public DemandeConge save(DemandeConge demandeConge, MultipartFile file)
	 * throws JsonParseException, JsonMappingException, Exception {
	 * 
	 * String filename = file.getOriginalFilename(); String newFileName =
	 * FilenameUtils.getBaseName(filename) + "." +
	 * FilenameUtils.getExtension(filename); File serverFile = new File(
	 * context.getRealPath(
	 * "C:\\Users\\HP\\git\\dev_ressorce\\TP-JWT\\src\\main\\resources\\uploads\\"+
	 * File.separator + newFileName));
	 * 
	 * try {
	 * 
	 * System.out.println("--------------------------------- go");
	 * FileUtils.writeByteArrayToFile(serverFile, file.getBytes());
	 * 
	 * } catch (Exception e) { e.printStackTrace();
	 * demandeCongeDao.save(demandeConge); }
	 * 
	 * demandeConge.setCertificat("projet"); return
	 * demandeCongeDao.save(demandeConge); }
	 */

}
