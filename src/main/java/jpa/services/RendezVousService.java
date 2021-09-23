package jpa.services;

import jpa.business.RendezVous;
import jpa.dao.RendezVousManager;

public class RendezVousService {
    private RendezVousManager manager;

    public RendezVousService(RendezVousManager manager) {
        this.manager = manager;
    }

    public RendezVous add(RendezVous rdv){
        manager.save(rdv);
        return rdv;
    }
}
