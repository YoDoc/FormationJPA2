package com.softeam.formation.jpa.metier.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Salle {
	@Version
	@Column(name = "version_field")
	private int version;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name = "nom")
	protected String nom;
	@Column(name = "nbplaces")
	protected Integer nbPlaces;
	
	public Salle(){}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Integer getNbPlaces() {
		return nbPlaces;
	}
	
	public void setNbPlaces(Integer nbPlaces) {
		this.nbPlaces = nbPlaces;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}	
}
