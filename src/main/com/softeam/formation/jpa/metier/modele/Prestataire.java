package com.softeam.formation.jpa.metier.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Collaborateur")
public class Prestataire extends Personne {

	protected String societe;
	
	public Prestataire(){}

	@Column(name="Societe")
	public String getSociete() {
		return societe;
	}
	public void setSociete(String societe) {
		this.societe = societe;
	}
	
}
