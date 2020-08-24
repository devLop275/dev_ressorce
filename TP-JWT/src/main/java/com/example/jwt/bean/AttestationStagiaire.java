package com.example.jwt.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AttestationStagiaire {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private Employee encadrant;

	@ManyToOne
	private Stagiaire stagiaire;

	private Date dateAttestation;

	private String description;

	@ManyToOne
	private TypeAttestation typeAttestation;

	public Employee getEncadrant() {
		return encadrant;
	}

	public void setEncadrant(Employee encadrant) {
		this.encadrant = encadrant;
	}

	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
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

}
