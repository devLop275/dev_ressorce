package com.example.jwt.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
@Entity
public class DemandeConge {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	@ManyToOne
	private Employee employee;
	@ManyToOne
	private TypeConge typeConge;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dateDebut;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dateFin;
	private int duree;
	private String horaire;
	private String raison;
	private String certificat;
	private String status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public TypeConge getTypeConge() {
		return typeConge;
	}
	public void setTypeConge(TypeConge typeConge) {
		this.typeConge = typeConge;
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
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}

	public String getHoraire() {
		return horaire;
	}
	public void setHoraire(String horaire) {
		this.horaire = horaire;
	}
	public String getRaison() {
		return raison;
	}
	public void setRaison(String raison) {
		this.raison = raison;
	}
	public String getCertificat() {
		return certificat;
	}
	public void setCertificat(String certificat) {
		this.certificat = certificat;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
