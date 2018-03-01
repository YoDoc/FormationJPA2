package com.softeam.formation.jpa.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


import com.softeam.formation.jpa.metier.dao.impl.PersonneDAOImpl;
import com.softeam.formation.jpa.metier.modele.Personne;

public class Exercice10 {

	private static EntityManagerFactory emf = null;
	private static EntityManager em = null;
	
	public static void main(String[] args) {
		
		emf = Persistence.createEntityManagerFactory("hibernate");
		em = emf.createEntityManager();

		
		EntityTransaction t = em.getTransaction();
		t.begin();

		Personne p1 = new Personne();
		p1.setEmail("Jean");
		p1.setAge(70);
		
		Personne p2 = new Personne();
		p2.setEmail("Francois");
		p2.setAge(71);
		
		Personne p3 = new Personne();
		p3.setEmail("Ivan");
		p3.setAge(58);
		
		
		Personne p4 = new Personne();
		p4.setEmail("Marie");
		p4.setAge(66);
		
		Personne p5 = new Personne();
		p5.setEmail("Alphonse");
		p5.setAge(32);
		
		Personne p6 = new Personne();
		p6.setEmail("Michel");
		p6.setAge(89);
		
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.persist(p4);		
		em.persist(p5);
		em.persist(p6);
		
		String requete1 = "Select p.email from Personne p ";
		Query q = em.createQuery(requete1);
		List<?> listePersonne = q.getResultList();
		System.out.println("la liste des personnes"+listePersonne);
		
		String requete2 = "Select p.email from Personne p WHERE p.age<60";
		Query q2 = em.createQuery(requete2);
		List<?> listePersonneAuMoins50 = q2.getResultList();
		System.out.println("la liste des personnes d'au moins 50 ans"+listePersonneAuMoins50);
		
		t.commit();
		em.close();
		emf.close();
		
	}

}
