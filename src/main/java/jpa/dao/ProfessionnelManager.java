package jpa.dao;

import jpa.business.Compte;
import jpa.business.Professionnel;
import jpa.business.RdvInfos;
import jpa.business.Utilisateur;

import javax.persistence.NoResultException;

public class ProfessionnelManager extends GenericManager<Professionnel,Long>
{
    private CompteManager compteManager;

    public ProfessionnelManager(CompteManager compteManager) {
        this.compteManager = compteManager;
    }

    public Professionnel getProfessionnelById(Long id){
        return (Professionnel) compteManager.getCompteById(id,Professionnel.class);
    }

    public Professionnel getProfessionnelByLogin(String login){
        return (Professionnel) compteManager.getCompteByLogin(login,Professionnel.class);
    }

    public Professionnel getProfessionnelByName(String name){
        try {
            String query = String.format("SELECT a FROM Compte a WHERE DTYPE=%s AND name='%s'",
                    Professionnel.class.getName(),
                    name);
            return (Professionnel) entityManager.createQuery(query, Compte.class).getSingleResult();
        }
        catch(NoResultException e){
            return null;
        }
    }
}
