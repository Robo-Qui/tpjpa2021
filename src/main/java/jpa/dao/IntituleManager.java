package jpa.dao;

import jpa.EntityManagerHelper;
import jpa.business.Intitule;

import javax.persistence.EntityManager;

public class IntituleManager {
    EntityManager manager = EntityManagerHelper.getEntityManager();

    public void Create(Intitule inti){
        manager.persist(inti);
    }
}
