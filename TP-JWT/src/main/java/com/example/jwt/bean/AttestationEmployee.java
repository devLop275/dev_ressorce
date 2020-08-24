package com.example.jwt.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AttestationEmployee {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    @ManyToOne
    private Employee employee;
    
    private String manager;
    
    private Date dateAttestation;
    
    private String description;
    
    @ManyToOne
    private TypeAttestation typeAttestation;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getDateAttestation() {
		return dateAttestation;
	}

	public void setDateAttestation(Date dateAttestation) {
		this.dateAttestation = dateAttestation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TypeAttestation getTypeAttestation() {
		return typeAttestation;
	}

	public void setTypeAttestation(TypeAttestation typeAttestation) {
		this.typeAttestation = typeAttestation;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}
     
	
    
}
