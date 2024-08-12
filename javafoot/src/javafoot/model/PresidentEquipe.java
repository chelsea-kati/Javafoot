
package javafoot.model;


public class PresidentEquipe {
    
    private int idpresident;
    private String nom,prenom,email;  
    

    public PresidentEquipe(int idpresident, String nom, String prenom, String email) {
        this.idpresident = idpresident;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }
    public PresidentEquipe(){
        
    }

    public int getIdpresident() {
        return idpresident;
    }

    public void setIdpresident(int idpresident) {
        this.idpresident = idpresident;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
         public String getIDnompresident(){
        return idpresident+" "+nom+" "+prenom;}
    
  
    
}
