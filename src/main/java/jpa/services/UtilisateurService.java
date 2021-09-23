package jpa.services;

import jpa.business.FreeSlot;
import jpa.business.Professionnel;
import jpa.business.RendezVous;
import jpa.business.Utilisateur;
import jpa.dao.UtilisateurManager;

public class UtilisateurService {
    private UtilisateurManager manager;
    private ProfessionnelService profService;
    private RendezVousService rdvService;

    public UtilisateurService(UtilisateurManager manager, ProfessionnelService profService, RendezVousService rdvService){
        this.manager = manager;
        this.profService = profService;
        this.rdvService = rdvService;
    }

    public Utilisateur getById(Long id){
        return manager.getUtilisateurById(id);
    }

    public Utilisateur getByLogin(String login){
        return manager.getUtilisateurByLogin(login);
    }

    public RendezVous addAppointement(Long utilId, Long profId, FreeSlot slot) throws Exception{
        Utilisateur util = getById(utilId);
        Professionnel prof = profService.getById(profId);
        if(util!=null && prof!=null){
            if(prof.getFreeSlots().contains(slot)){
                profService.removeFreeSlot(prof, slot);
                return rdvService.add(new RendezVous(prof,util,slot.getStartTime(),slot.getEndTime()));
            }
            else{
                throw new Exception("Slot inexistant");
            }
        }
        else{
            throw new Exception("Professionnel ou Utilisateur not found");
        }
    }

    public Utilisateur addUtilisateur(Utilisateur util) throws Exception {
        if(getByLogin(util.getLogin()) == null){
            manager.save(util);
            return util;
        }
        else{
            throw new Exception("Utilisateur déjà existant");
        }
    }
}
