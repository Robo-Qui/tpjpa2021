package jpa.business;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class Professionnel extends Compte{
    private String name;
    RdvInfos infoRdv;
    List<FreeSlot> freeSlots;

    public Professionnel(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne
    public RdvInfos getRdvInfos() {
        return infoRdv;
    }

    public void setRdvInfos(RdvInfos rdvInfo) {
        this.infoRdv = rdvInfo;
    }

    @OneToMany
    public List<FreeSlot> getFreeSlots() {
        return freeSlots;
    }

    public void setFreeSlots(List<FreeSlot> freeSlots) {
        this.freeSlots = freeSlots;
    }

    @Override
    public String ToString(){
        return String.format("Profesionnel %s, Durée de RDV: %s, Motifs de RDV %s\n Créneaux disponibles %s",
                this.name,this.infoRdv.getDuree(),this.infoRdv.getIntitules(),this.freeSlots
        );
    }
}
