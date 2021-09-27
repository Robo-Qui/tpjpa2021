package jpa;

import jpa.business.*;
import jpa.dao.*;
import jpa.services.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

public class JpaTest {

	public EntityManager manager;
	private UtilisateurService utilService;
	private ProfessionnelService profService;

	public JpaTest(EntityManager manager){
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		JpaTest test = new JpaTest(EntityManagerHelper.getEntityManager());
		test.profService = new ProfessionnelService(new ProfessionnelManager(new CompteManager()),new FreeSlotService(new FreeSlotManager()),new RdvInfosService(new RdvInfosManager(),new IntituleService(new IntituleManager())));
		test.utilService = new UtilisateurService(new UtilisateurManager(new CompteManager()),test.profService,new RendezVousService(new RendezVousManager()));
		EntityTransaction tx = test.manager.getTransaction();
		tx.begin();
		try {
			test.utilService.addUtilisateur(new Utilisateur("PAPOPE","PAPOPE"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		Professionnel prof = test.profService.getByLogin("login");

		if(prof != null){
			System.out.println(prof);
		}
		else{
			System.out.println("No user was found");
		}

		test.manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
	}
}
