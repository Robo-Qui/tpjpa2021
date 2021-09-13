package jpa;

import jpa.business.*;
import jpa.dao.IntituleManager;
import jpa.dao.ProfessionnelManager;
import jpa.dao.RdvInfosManager;
import jpa.dao.UtilisateurManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

public class JpaTest {

	public EntityManager manager;

	public JpaTest(EntityManager manager){
		this.manager = manager;
	}

	public void createUtilisateur(){

		String query = "Select a From Compte a Where DTYPE='Utilisateur'";
		int numUtilisateurs = manager.createQuery(query, Compte.class).getResultList().size();
		if(numUtilisateurs==0){
			new UtilisateurManager().save((new Utilisateur("PAPOPE","PAPOPE")));
		}
	}

	public void createProfessionnel(){
		Professionnel prof = new Professionnel("prof","prof","Professionnel");
		ArrayList<Intitule> intitules = new ArrayList<>();
		Intitule intitule = new Intitule("Chirurgie Dentaire");
		createIntitule(intitule);
		intitules.add(intitule);
		RdvInfos rdvInfos = new RdvInfos(60,intitules);
		createRdvInfos(rdvInfos);
		prof.setRdvInfos(rdvInfos);
		(new ProfessionnelManager()).save(prof);
	}

	private void createRdvInfos(RdvInfos rdvInfos) {
		(new RdvInfosManager()).save(rdvInfos);
	}

	private void createIntitule(Intitule intitule) {
		(new IntituleManager()).save(intitule);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		JpaTest test = new JpaTest(EntityManagerHelper.getEntityManager());
		EntityTransaction tx = test.manager.getTransaction();
		tx.begin();
		try {
			test.createUtilisateur();
			test.createProfessionnel();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		test.manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
	}
}
