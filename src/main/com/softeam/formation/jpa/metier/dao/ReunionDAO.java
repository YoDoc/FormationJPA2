package com.softeam.formation.jpa.metier.dao;

import com.softeam.formation.jpa.metier.modele.Reunion;

public interface ReunionDAO {

	public void ajouter(Reunion t) throws Exception;
	
	public Reunion lire(int id) throws Exception;
	
	public Boolean modifier(Reunion p) throws Exception; 
}
