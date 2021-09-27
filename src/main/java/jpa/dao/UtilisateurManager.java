package jpa.dao;

import jpa.business.Compte;
import jpa.business.Utilisateur;

import javax.persistence.criteria.*;

public class UtilisateurManager extends GenericManager<Utilisateur, Long> {
    private CompteManager compteManager;

    public UtilisateurManager(CompteManager compteManager) {
        this.compteManager = compteManager;
    }

    public Utilisateur getUtilisateurById(Long id){
        return (Utilisateur) compteManager.getCompteById(id,Utilisateur.class);
    }

    public Utilisateur getUtilisateurByLogin(String login){
        return (Utilisateur) compteManager.getCompteByLogin(login,Utilisateur.class);
    }
}
