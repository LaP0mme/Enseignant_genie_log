package champollion;

import java.util.*;

public class Intervention {
    public Date debut;
    public int duree;
    public boolean annulee;
    private int heuredebut;
    private TypeIntervention type;
    private Salle lieu;
    private UE matiere;

    public Intervention(Date debut, int duree, int heuredebut, UE matiere, TypeIntervention type) {
        this.debut = debut;
        this.duree = duree;
        this.annulee = false;
        this.heuredebut = heuredebut;
        this.type = type;
        this.matiere = matiere;

    }

    public boolean reservation(Salle salle) {
        boolean flag = true;
        for (int i = 0; i < salle.Interventionprevues.size(); i++) {
            if (this.debut == salle.Interventionprevues.get(i).debut) {
                if (this.heuredebut == salle.Interventionprevues.get(i).heuredebut ||
                        (this.heuredebut < salle.Interventionprevues.get(i).heuredebut
                                + salle.Interventionprevues.get(i).getDuree() &&
                                this.heuredebut > salle.Interventionprevues.get(i).heuredebut
                                        + salle.Interventionprevues.get(i).getDuree())
                        ||
                        (this.heuredebut + this.duree < salle.Interventionprevues.get(i).heuredebut
                                + salle.Interventionprevues.get(i).getDuree() &&
                                this.heuredebut + this.duree > salle.Interventionprevues.get(i).heuredebut)
                        ||
                        this.heuredebut + this.duree == salle.Interventionprevues.get(i).heuredebut) {
                    if (salle.Interventionprevues.get(i).annulee == false) {
                        flag = false;
                    }
                }
            }

        }
        this.lieu = salle;
        salle.Interventionprevues.add(this);
        return flag;
    }

    public UE getMatiere() {
        return this.matiere;
    }

    public TypeIntervention getType() {
        return this.type;
    }

    public int getDuree() {
        return this.duree;
    }

    public void setAnnulee(boolean annulation) {
        this.annulee = annulation;
    }

}