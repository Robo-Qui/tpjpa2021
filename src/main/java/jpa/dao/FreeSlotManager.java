package jpa.dao;

import jpa.EntityManagerHelper;
import jpa.business.FreeSlot;

import javax.persistence.EntityManager;

public class FreeSlotManager {
    EntityManager manager = EntityManagerHelper.getEntityManager();

    public void Create(FreeSlot slot){
        manager.persist(slot);
    }
}
