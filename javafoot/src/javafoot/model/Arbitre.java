
package javafoot.model;


public class Arbitre {

    public Arbitre(int idarbitre, String nom, String prenom, String poste) {
        this.idarbitre = idarbitre;
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
    }
public Arbitre(){}

    public int getIdarbitre() {
        return idarbitre;
    }

    public void setIdarbitre(int idarbitre) {
        this.idarbitre = idarbitre;
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

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }
    private int idarbitre;
    private String nom,prenom,poste;
    
}
