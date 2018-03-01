package com.softeam.formation.jpa.metier.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.softeam.formation.jpa.metier.dao.PersonneDAO;
import com.softeam.formation.jpa.metier.modele.Personne;

public class PersonneDAOImpl implements PersonneDAO {
	
	private EntityManager em;
	
	public PersonneDAOImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void ajouter(Personne p) throws Exception {
		EntityTransaction tx = em.getTransaction();
		try
		{
			tx.begin();
			em.persist(p);
			tx.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			tx.rollback();
			throw e;
		}
	}

	@Override
	public Personne lire(int id) throws Exception {
		EntityTransaction tx = em.getTransaction();
		try
		{
			tx.begin();
			
			Personne p = em.find(Personne.class, id);
			
			tx.commit();
			return p;
		}
		catch(Exception e)
		{
			tx.rollback();
			throw e;
		}
	}

	@Override
	public Boolean modifier(Personne p) throws Exception {
		if(p != null){
			EntityTransaction tx = em.getTransaction();
			try {
				tx.begin();
				
				em.merge(p);
				
				tx.commit();
				return true;
			}
			catch(Exception e) {
				e.printStackTrace();
				tx.rollback();
				em.close();
				throw e;
			}
		} else {
			return false;
		}
		
	}

	@Override
	public Boolean supprimer(Personne p) throws Exception {
		if(p != null){
			EntityTransaction tx = em.getTransaction();
			try
			{
				tx.begin();
				
				em.remove(p);
				
				tx.commit();
				return true;
			}
			catch(Exception e)
			{
				tx.rollback();
				throw e;
			}
		} else {
			return false;
		}
	}

}
