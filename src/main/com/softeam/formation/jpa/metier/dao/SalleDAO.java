package com.softeam.formation.jpa.metier.dao;

import com.softeam.formation.jpa.metier.modele.Salle;

public interface SalleDAO {
	
	public void ajouter(Salle t) throws Exception;
	
	public Salle lire(int id) throws Exception;
}
