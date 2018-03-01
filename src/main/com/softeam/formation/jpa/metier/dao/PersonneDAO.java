package com.softeam.formation.jpa.metier.dao;

import com.softeam.formation.jpa.metier.modele.Personne;

public interface PersonneDAO {
	
	public void ajouter(Personne p) throws Exception;
	
	public Personne lire(int id) throws Exception;
	
	public Boolean modifier(Personne p) throws Exception;
	
	public Boolean supprimer(Personne p) throws Exception;
}
