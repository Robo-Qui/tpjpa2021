package jpa.dao;

import jpa.EntityManagerHelper;
import jpa.business.RdvInfos;

import javax.persistence.EntityManager;

public class RdvInfosManager {
    EntityManager manager = EntityManagerHelper.getEntityManager();

    public void Create(RdvInfos infos){
        manager.persist(infos);
    }
}
