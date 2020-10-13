package com.example.jwt.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Stage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	private String raison;
	private String etat;
	
	@ManyToOne
	private Employee encadrent;
	
	@OneToMany(mappedBy = "stage")
	private List<EquipeItem> equipeItems;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRaison() {
		return raison;
	}

	public void setRaison(String raison) {
		this.raison = raison;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Employee getEncadrent() {
		return encadrent;
	}

	public void setEncadrent(Employee encadrent) {
		this.encadrent = encadrent;
	}


	public List<EquipeItem> getEquipeItems() {
		return equipeItems;
	}

	public void setEquipeItems(List<EquipeItem> equipeItems) {
		this.equipeItems = equipeItems;
	}

	
}