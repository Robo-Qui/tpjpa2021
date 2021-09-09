package jpa.dao;

import jpa.EntityManagerHelper;
import jpa.business.Professionnel;

import javax.persistence.EntityManager;

public class ProfessionnelManager {
    EntityManager manager = EntityManagerHelper.getEntityManager();

    public void Create(Professionnel prof){
        manager.persist(prof);
    }
}
