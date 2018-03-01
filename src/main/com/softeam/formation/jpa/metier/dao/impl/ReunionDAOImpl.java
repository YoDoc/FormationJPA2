package com.softeam.formation.jpa.metier.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.softeam.formation.jpa.metier.dao.ReunionDAO;
import com.softeam.formation.jpa.metier.modele.Reunion;

public class ReunionDAOImpl implements ReunionDAO {

	private EntityManager em;
	
	public ReunionDAOImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void ajouter(Reunion reunion) throws Exception {
		EntityTransaction tx = em.getTransaction();
		try
		{
			tx.begin();
			em.persist(reunion);
			tx.commit();
		}
		catch(Exception e)
		{
			tx.rollback();
			throw e;
		}
	}

	@Override
	public Reunion lire(int id) throws Exception {
		EntityTransaction tx = em.getTransaction();
		try
		{
			tx.begin();
			
			Reunion r = em.find(Reunion.class, id);
			
			tx.commit();
			return r;
		}
		catch(Exception e)
		{
			tx.rollback();
			throw e;
		}
	}

	@Override
	public Boolean modifier(Reunion p) throws Exception {
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

}
