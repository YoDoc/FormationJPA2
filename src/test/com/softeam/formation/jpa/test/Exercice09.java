package com.softeam.formation.jpa.test;

import java.util.Calendar;

import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softeam.formation.jpa.metier.modele.Reunion;

public class Exercice09 {
	
	private static Logger logger = LoggerFactory.getLogger(Exercice09.class);
	
	private static EntityManagerFactory emf = null;
	private static EntityManager em = null;
	
	public static void main(String[] args) {
		logger.info("----Exercice 09----");
		
		emf = Persistence.createEntityManagerFactory("hibernate");
		em = emf.createEntityManager();

		//test1();
		//test2();
		test3();
		
		em.close();
		
		logger.info("----FIN----");
	}
	
	public static void test1() {

		Reunion reunion = null;
		
		EntityTransaction t = em.getTransaction();

		try {
			t.begin();
			// Récupérer en base de données une instance existante de Reunion, puis l'afficher
			logger.info("Récupérer en base de données une instance existante de Reunion, puis l'afficher");
			reunion = (Reunion) em.find(Reunion.class, 151);
			logger.info(reunion.getId() + " / " + reunion.getTitre());

			// Modifier le titre de la réunion via le setter associé
			logger.info("Modifier le titre de la réunion via le setter associé");
			// le dirty checking entre en action, si l'objet n'a pas été détaché
			reunion.setTitre("Reunion répérée et modifiée " + Calendar.getInstance().getTime());

			//flush
			//constate que l'ordre update est bien envoyé au moment du flush
			//la modif n'est pas visible en base avant le commit à cause
			//de l'isolation des transactions
			em.flush();
			t.commit();
			logger.info("Commit de la transaction effectuée");
		} catch (Exception e) {
			logger.error("Erreur " + e.getMessage(), e);
			t.rollback();
		}
	}
	
	public static void test2() {

		Reunion reunion = null;
		
		EntityTransaction t = em.getTransaction();

		try {
			emf.getCache().evictAll();
			
			t.begin();
			// Récupérer en base de données une instance existante de Reunion, puis l'afficher
			logger.info("Récupérer en base de données une instance existante de Reunion, puis l'afficher");
			reunion = (Reunion) em.find(Reunion.class, 151);
			logger.info(reunion.getId() + " / " + reunion.getTitre());
			
			// détacher la réuion
			em.detach(reunion);
			
			// Modifier le titre de la réunion via le setter associé
			logger.info("Modifier le titre de la réunion via le setter associé");
			// le dirty checking entre en action, si l'objet n'a pas été détaché
			reunion.setTitre("Reunion répérée et modifiée " + Calendar.getInstance().getTime());

			em.flush();
			t.commit();
			logger.info("Commit de la transaction effectué");			
		} catch (Exception e) {
			logger.error("Erreur " + e.getMessage(), e);
			t.rollback();
		}
	}

	public static void test3() {

		Reunion reunion = null;
		EntityTransaction t = em.getTransaction();

		try {
			t.begin();
			// Récupérer en base de données une instance existante de Reunion, puis l'afficher
			logger.info("Récupérer en base de données une instance existante de Reunion, puis l'afficher");
			reunion = (Reunion) em.find(Reunion.class, 151);
			logger.info(reunion.getId() + " / " + reunion.getTitre());

			// détacher la réuion
			em.detach(reunion);

			// Modifier le titre de la réunion via le setter associé
			logger.info("Modifier le titre de la réunion via le setter associé");
			// le dirty checking entre en action, si l'objet n'a pas été détaché
			reunion.setTitre("Reunion répérée et modifiée " + Calendar.getInstance().getTime());

			//flush
			//constate que l'ordre update est bien envoyé au moment du flush
			//la modif n'est pas visible en base avant le commit à cause
			//de l'isolation des transactions
			em.flush();
			
			//ajout d'un update explicite en + du evict
			// modifier (explicitement) la réuion
			em.merge(reunion);
			t.commit();
			logger.info("Commit de la transaction effectué");
			
		} catch (Exception e) {
			logger.error("Erreur " + e.getMessage(), e);
			t.rollback();
		}
	}
}
