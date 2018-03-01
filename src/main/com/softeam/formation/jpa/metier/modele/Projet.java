package com.softeam.formation.jpa.metier.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Projet {
	@Version
	@Column(name = "version_field")
	private int version;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name = "nom")
	protected String nom;
	
	public Projet(){}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
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
