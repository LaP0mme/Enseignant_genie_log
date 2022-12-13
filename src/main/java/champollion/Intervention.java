package champollion;

import java.time.*;

public class Intervention {
    public LocalDate debut;
    public int duree;
    public boolean annulee;
    private int heuredebut;
    private TypeIntervention type;
    private Salle lieu;

    public Intervention(LocalDate debut, int duree, int heuredebut, TypeIntervention type) {
        this.debut = debut;
        this.duree = duree;
        this.annulee = false;
        this.heuredebut = heuredebut;
        this.type = type;

    }

    public boolean reservation(Salle salle) {
        boolean flag = true;
        for (int i = 0; i < salle.Interventionprevues.size(); i++) {
            if (this.debut == salle.Interventionprevues.get(i).getDate()) {
                if (this.heuredebut == salle.Interventionprevues.get(i).getHeureDebut() ||
                        (this.heuredebut < salle.Interventionprevues.get(i).getHeureDebut()
                                + salle.Interventionprevues.get(i).getDuree() &&
                                this.heuredebut > salle.Interventionprevues.get(i).getHeureDebut()
                                        + salle.Interventionprevues.get(i).getDuree())
                        ||
                        (this.heuredebut + this.duree < salle.Interventionprevues.get(i).getHeureDebut()
                                + salle.Interventionprevues.get(i).getDuree() &&
                                this.heuredebut + this.duree > salle.Interventionprevues.get(i).getHeureDebut())
                        ||
                        this.heuredebut + this.duree == salle.Interventionprevues.get(i).getHeureDebut()) {
                    if (salle.Interventionprevues.get(i).getAnulee() == false) {
                        flag = false;
                    }
                }
            }

        }
        this.lieu = salle;
        salle.Interventionprevues.add(this);
        return flag;
    }

    public Salle getLieu() {
        return this.lieu;
    }

    public LocalDate getDate() {
        return this.debut;
    }

    public void setDate(LocalDate newDate) {
        this.debut = newDate;
    }

    public int getDuree() {
        return this.duree;
    }

    public void setDuree(int newDuree) {
        this.duree = newDuree;
    }

    public boolean getAnulee() {
        return this.annulee;
    }

    public void setAnulee(boolean annule) {
        this.annulee = annule;
    }

    public int getHeureDebut() {
        return this.heuredebut;
    }

    public void setHeureDebut(int newHeure) {
        this.heuredebut = newHeure;
    }

    public TypeIntervention getTypeIntervention() {
        return this.type;
    }

    public void setTypeIntervention(TypeIntervention newType) {
        this.type = newType;
    }

}
