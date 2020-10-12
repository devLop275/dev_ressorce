package com.example.jwt.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.example.jwt.bean.AttestationStagiaire;
import com.example.jwt.bean.Employee;
import com.example.jwt.bean.Stagiaire;
import com.example.jwt.dao.AttestationStagiareDao;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;

@Service
public class AttestationStagiaireImpl {

	@Autowired
	private AttestationStagiareDao attestationStagiareDao;

	public AttestationStagiaire save(AttestationStagiaire attestationStagiaire) {
		return attestationStagiareDao.save(attestationStagiaire);
	}

	public List<AttestationStagiaire> findAll() {
		return attestationStagiareDao.findAll();
	}

	public AttestationStagiaire findStageAndEquipeItemAndStagiaireByNom(String nom) {
		return attestationStagiareDao.findStageAndEquipeItemAndStagiaireByNom(nom);
	}

	/*public AttestationStagiaire findByStagiaire(Stagiaire stagiaire) {
		return attestationStagiareDao.findByStagiaire(stagiaire);
	}*/

	public void deleteById(Long id) {
		attestationStagiareDao.deleteById(id);
	}
	
	public List<Stagiaire> findStagiaireAndEquipeItem() {
		return attestationStagiareDao.findStagiaireAndEquipeItem();
	}

	public String exportReport(String reportFormat, String nom) throws FileNotFoundException, JRException {
		String path = "src/main/resources/attestationFiles/";
		AttestationStagiaire attestationSt = attestationStagiareDao.findStageAndEquipeItemAndStagiaireByNom(nom);
		System.out.println("----------------" + attestationSt); // load file and compile it
		File file = ResourceUtils.getFile("classpath:attestation_stagiaire.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanArrayDataSource dataSource = new JRBeanArrayDataSource(new AttestationStagiaire[] { attestationSt });
		System.out.println(dataSource.getData());
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("createdBy", "Abderrahim");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		if (reportFormat.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "/"+ attestationSt.getNomSt()+"_"+ attestationSt.getPrenomSt() +".html");
		}
		if (reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "/"+ attestationSt.getNomSt()+"_"+ attestationSt.getPrenomSt() +".pdf");
		}

		return "report generated in path : " + path;
	}

}
