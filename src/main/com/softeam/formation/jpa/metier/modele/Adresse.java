package com.softeam.formation.jpa.metier.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
public class Adresse {
	
	private int version;
	private int id;

	protected String ligne1;
	protected String ligne2;
	protected String ligne3;
	protected String codePostal;
	protected String ville;
	protected Personne personne;


	public Adresse(){}
	
	@Column(name="ligne1")
	public String getLigne1() {
		return ligne1;
	}
	public void setLigne1(String ligne1) {
		this.ligne1 = ligne1;
	}
	
	@Column(name="ligne2")
	public String getLigne2() {
		return ligne2;
	}
	public void setLigne2(String ligne2) {
		this.ligne2 = ligne2;
	}
	
	@Column(name="ligne3")
	public String getLigne3() {
		return ligne3;
	}
	public void setLigne3(String ligne3) {
		this.ligne3 = ligne3;
	}
	
	@Column(name="codepostal")
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	
	@Column(name="ville")
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Transient
	public Personne getPersonne() {
		return personne;
	}
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	
	@Version
	@Column(name = "version_field")
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}	
}