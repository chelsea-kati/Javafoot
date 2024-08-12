
package javafoot.model;


public class Coach {
        private int idcoach;
    private String nom,prenom,age,nationalite;

    public Coach(int idcoach, String nom, String prenom, String age, String nationalite) {
        this.idcoach = idcoach;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.nationalite = nationalite;
    }
    public Coach(){

    }

    public int getIdcoach() {
        return idcoach;
    }

    public void setIdcoach(int idcoach) {
        this.idcoach = idcoach;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

          public String getIDnomCoach(){
        return idcoach+" "+nom+" "+prenom;}
    
}
