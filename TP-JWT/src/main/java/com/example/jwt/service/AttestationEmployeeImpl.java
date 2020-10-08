package com.example.jwt.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.example.jwt.bean.AttestationEmployee;
import com.example.jwt.bean.Employee;
import com.example.jwt.dao.AttestationEmployeeDao;
import com.example.jwt.dao.EmployeeDao;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class AttestationEmployeeImpl {

	@Autowired
	private AttestationEmployeeDao attestationEmployeeDao;
	@Autowired
	private EmployeeDao employeeDao;

	public AttestationEmployee save(AttestationEmployee attestationEmployee) {
		return attestationEmployeeDao.save(attestationEmployee);
	}

	public List<AttestationEmployee> findAll() {
		return attestationEmployeeDao.findAll();
	}

	public AttestationEmployee findByEmployee(Employee employee) {
		return attestationEmployeeDao.findByEmployee(employee);
	}

	public void deleteById(Long id) {
		attestationEmployeeDao.deleteById(id);
	}
	
	public String exportReport(String reportFormat,String nom) throws FileNotFoundException, JRException {
        String path = "/Users/ayoubealhyane/Desktop/Report";
        Employee employee = employeeDao.findByNom(nom);
        System.out.println("----------------"+employee.getNom());
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:attestation_employee.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanArrayDataSource dataSource = new JRBeanArrayDataSource(new Employee[] {employee});
        System.out.println(dataSource.getData());
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Abdo Al");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "/"+employee.getNom()+".html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "/"+employee.getNom()+".pdf");
        }

        return "report generated in path : " + path;
    }
	
}
