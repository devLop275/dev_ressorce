package com.example.jwt.bean;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Stagiaire extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@ManyToOne
	private Departement departement;
	
	@ManyToOne
	private Designation designation;

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}
	
	
	
}
