package com.softeam.formation.jpa.metier.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.softeam.formation.jpa.metier.dao.ProjetDAO;
import com.softeam.formation.jpa.metier.modele.Projet;

public class ProjetDAOImpl implements ProjetDAO {
	
	private EntityManager em;
	
	public ProjetDAOImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public void ajouter(Projet projet) throws Exception {
		EntityTransaction tx = em.getTransaction();
		try
		{
			tx.begin();
			em.persist(projet);
			tx.commit();
		}
		catch(Exception e)
		{
			tx.rollback();
			throw e;
		}
	}

	@Override
	public Projet lire(int id) throws Exception {
		EntityTransaction tx = em.getTransaction();
		try
		{
			tx.begin();
			
			Projet p = em.find(Projet.class, id);
			
			tx.commit();
			return p;
		}
		catch(Exception e)
		{
			tx.rollback();
			throw e;
		}
	}
}
