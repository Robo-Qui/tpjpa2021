package jpa.dao;

import jpa.business.Professionnel;
import jpa.business.Utilisateur;

public class ProfessionnelManager extends GenericManager<Professionnel,Long>
{
    public Professionnel getProfessionnelById(Long id){
        return (Professionnel) (new CompteManager()).getCompteById(id,Professionnel.class);
    }
}
