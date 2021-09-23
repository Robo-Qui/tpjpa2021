package jpa.services;

import jpa.business.Intitule;
import jpa.business.Professionnel;
import jpa.dao.IntituleManager;

import java.util.List;

public class IntituleService {
    private IntituleManager manager;

    public IntituleService(IntituleManager manager) {
        this.manager = manager;
    }


    public List<Intitule> add(List<Intitule> intitules) {
        for(Intitule intitule : intitules){
            manager.save(intitule);
        }
        return intitules;
    }
}
