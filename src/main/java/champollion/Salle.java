package champollion;

import java.util.*;

public class Salle {
    // on met les attibuts en public comme indiqué dans le diagramme UML
    public String intitule;
    public int capacite;
    public ArrayList<Intervention> Interventionprevues;

    public Salle(String intitule, int capacite){
        this.capacite = capacite;
        this.intitule = intitule;
        this.Interventionprevues = new ArrayList<Intervention>();
    }

    public ArrayList<Intervention> getInterventionPrevues(){
        return this.Interventionprevues;
    }
    
}
