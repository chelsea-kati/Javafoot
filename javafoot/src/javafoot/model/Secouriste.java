

package javafoot.model;


public class Secouriste {
     private int idsecouriste;
    private String nom,prenom,medicaments,outilssecours;
    

    public Secouriste(int idsecouriste, String nom, String prenom, String medicaments,String outilssecours) {
        this.idsecouriste = idsecouriste;
        this.nom = nom;
        this.prenom = prenom;
       this.medicaments = medicaments;
         this.outilssecours = outilssecours;
    }
public Secouriste(){}

    public int getIdsecouriste() {
        return idsecouriste;
    }

    public void setIdsecouriste(int idsecouriste) {
        this.idsecouriste = idsecouriste;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
 public String getMedicaments() {
        return medicaments;
    }

    public void setMedicaments(String medicaments) {
        this.medicaments = medicaments;
    }
  
       
 public String getOutilssecours() {
        return outilssecours;
    }

    public void setOutilssecours(String outilssecours) {
        this.outilssecours = outilssecours;
    }
    
}