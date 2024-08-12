
package javafoot.model;
import java.time.LocalDate;

public class Joueur {
    
       private int idjoueur;
    private String nom,prenom;
    private LocalDate datenaissance;
    private String nationalite,position;
     private int equipe_id;
        private int coach_id;

    public Joueur(int idjoueur, String nom, String prenom, LocalDate datenaissance, String nationalite, String position, int equipe_id,int coach_id) {
        this.idjoueur = idjoueur;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaissance = datenaissance;
        this.nationalite = nationalite;
        this.position = position;
        this.equipe_id = equipe_id;
        this.coach_id = coach_id;
}
    public Joueur(){
}
    

    public int getIdjoueur() {
        return idjoueur;}

    public void setIdjoueur(int idjoueur) {
        this.idjoueur = idjoueur;
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

    public LocalDate getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(LocalDate datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getEquipe_id() {
        return equipe_id;
    }

    public void setEquipe_id(int equipe_id) {
        this.equipe_id = equipe_id;
    }
     
  public int getCoach_id() {
        return coach_id;
    }
   public void setCoach_id(int coach_id) {
        this.coach_id = coach_id;
    }
    
    
}
