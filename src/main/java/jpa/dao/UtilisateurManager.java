package jpa.dao;

import jpa.EntityManagerHelper;
import jpa.business.Utilisateur;

import javax.persistence.EntityManager;

public class UtilisateurManager {
    EntityManager manager = EntityManagerHelper.getEntityManager();

    public void Create(Utilisateur util){
        manager.persist(util);
    }
}
