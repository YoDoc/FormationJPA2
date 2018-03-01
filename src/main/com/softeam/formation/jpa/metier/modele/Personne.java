package com.softeam.formation.jpa.metier.modele;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Personne {
	protected int version;
	protected int id;

	protected String email;
	protected Integer age;
	protected Identite identite;

	protected List<Adresse> adresses = new ArrayList<Adresse>();

	protected CoordonnesTel coordonnesTel;

	public Personne() {}

	@Embedded
	public Identite getIdentite() {
		return identite;
	}
	public void setIdentite(Identite identite) {
		this.identite = identite;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "age")
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	@OneToMany(targetEntity=com.softeam.formation.jpa.metier.modele.Adresse.class,
			cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="personne_id")
	public List<Adresse> getAdresses() {
		return adresses;
	}
	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}

	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval=true)
	@JoinColumn(name="coordonneestel_id")
	public CoordonnesTel getCoordonnesTel() {
		return coordonnesTel;
	}
	public void setCoordonnesTel(CoordonnesTel coordonnesTel) {
		this.coordonnesTel = coordonnesTel;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
