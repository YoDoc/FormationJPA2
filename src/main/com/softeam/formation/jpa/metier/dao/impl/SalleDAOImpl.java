package com.softeam.formation.jpa.metier.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.softeam.formation.jpa.metier.dao.SalleDAO;
import com.softeam.formation.jpa.metier.modele.Salle;

public class SalleDAOImpl implements SalleDAO {
	
	private EntityManager em;
	
	public SalleDAOImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void ajouter(Salle salle) throws Exception {
		EntityTransaction tx = em.getTransaction();
		try
		{
			tx.begin();
			em.persist(salle);
			tx.commit();
		}
		catch(Exception e)
		{
			tx.rollback();
			throw e;
		}
	}

	@Override
	public Salle lire(int id) throws Exception {
		EntityTransaction tx = em.getTransaction();
		try
		{
			tx.begin();
			
			Salle s = em.find(Salle.class, id);
			
			tx.commit();

			return s;
		}
		catch(Exception e)
		{
			tx.rollback();
			throw e;
		}
	}

}
