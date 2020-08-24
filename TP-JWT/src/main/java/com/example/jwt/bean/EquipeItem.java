package com.example.jwt.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EquipeItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Stagiaire stagiaire;
	
	private Date dateDebut;
	
	private Date dateFin;
	
	private String emCv;
	
	private Date dateRecuCv;
	
	private double note;
	
	@ManyToOne
	private Stage stage;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
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

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public String getEmCv() {
		return emCv;
	}

	public void setEmCv(String emCv) {
		this.emCv = emCv;
	}

	public Date getDateRecuCv() {
		return dateRecuCv;
	}

	public void setDateRecuCv(Date dateRecuCv) {
		this.dateRecuCv = dateRecuCv;
	}
	
	
	
}
