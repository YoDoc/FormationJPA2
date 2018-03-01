package com.softeam.formation.jpa.metier.modele;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Identite {
	@Column(name="nom")
	protected String nom;
	@Column(name="prenom")
	protected String prenom;
	@Column(name="initiales")
	protected String initiales;
	
	public Identite(){}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getInitiales() {
		return initiales;
	}
	public void setInitiales(String initiales) {
		this.initiales = initiales;
	}
}
