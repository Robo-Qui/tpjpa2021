package jpa.dao;

import jpa.EntityManagerHelper;
import jpa.business.RendezVous;

import javax.persistence.EntityManager;

public class RendezVousManager {
    EntityManager manager = EntityManagerHelper.getEntityManager();

    public void Create(RendezVous rdv){
        manager.persist(rdv);
    }
}