package com.example.jwt.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AttestationStagiaire {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nomEnc;
	private String prenomEnc;
	private Date dateDebut;
	private Date dateFin;
	private String nomSt;
	private String prenomSt;
	private String departement;
	private String designation;
	
	//attestation
	public AttestationStagiaire(String nomEnc, String prenomEnc, Date dateDebut, Date dateFin, String nomSt,
			String prenomSt, String departement, String designation) {
		super();
		this.nomEnc = nomEnc;
		this.prenomEnc = prenomEnc;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.nomSt = nomSt;
		this.prenomSt = prenomSt;
		this.departement = departement;
		this.designation = designation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomEnc() {
		return nomEnc;
	}

	public void setNomEnc(String nomEnc) {
		this.nomEnc = nomEnc;
	}

	public String getPrenomEnc() {
		return prenomEnc;
	}

	public void setPrenomEnc(String prenomEnc) {
		this.prenomEnc = prenomEnc;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getNomSt() {
		return nomSt;
	}

	public void setNomSt(String nomSt) {
		this.nomSt = nomSt;
	}

	public String getPrenomSt() {
		return prenomSt;
	}

	public void setPrenomSt(String prenomSt) {
		this.prenomSt = prenomSt;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
