package com.softeam.formation.jpa.metier.modele;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.persistence.JoinColumn;

@Entity
public class Reunion {
	private int version;
	private int id;

	
	protected String titre;
	protected Date dateDebut;
	protected Date dateFin;

	protected List<Personne> participants = new ArrayList<Personne>();
	protected Salle salle;
	protected Projet projet;

	public Reunion() {
	}

	@Column(name = "titre")
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}

	@Column(name = "dateDebut")
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	@Column(name = "dateFin")
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	@ManyToMany
	@JoinTable(name="Participant_Reunion",
       joinColumns=@JoinColumn(name="reunion_id"),
       inverseJoinColumns=@JoinColumn(name="personne_id"))
	public List<Personne> getParticipants() {
		return participants;
	}
	public void setParticipants(List<Personne> participants) {
		this.participants = participants;
	}

	@ManyToOne(cascade=CascadeType.ALL)	
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	@ManyToOne(cascade=CascadeType.ALL)	
	public Projet getProjet() {
		return projet;
	}
	public void setProjet(Projet projet) {
		this.projet = projet;
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
