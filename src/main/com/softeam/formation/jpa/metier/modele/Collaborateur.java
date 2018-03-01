package com.softeam.formation.jpa.metier.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Collaborateur")
public class Collaborateur extends Personne {
	
	protected Integer salaire;
	protected String poste;
	
	public Collaborateur(){}
	
	@Column(name="salaire")
	public Integer getSalaire() {
		return salaire;
	}
	public void setSalaire(Integer salaire) {
		this.salaire = salaire;
	}
	
	@Column(name="poste")
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}	

}
