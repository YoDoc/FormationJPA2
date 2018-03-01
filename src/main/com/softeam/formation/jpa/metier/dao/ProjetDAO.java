package com.softeam.formation.jpa.metier.dao;

import com.softeam.formation.jpa.metier.modele.Projet;

public interface ProjetDAO {
	
	public void ajouter(Projet t) throws Exception;
	
	public Projet lire(int id) throws Exception;
}
