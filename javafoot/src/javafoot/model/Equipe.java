
package javafoot.model;


public class Equipe {
     private int idequipe;
    private String pays_equipe;
    private int coach_id,president_id;

    public Equipe(int idequipe, String pays_equipe, int coach_id, int president_id) {
        this.idequipe = idequipe;
        this.pays_equipe = pays_equipe;
        this.coach_id = coach_id;
        this.president_id = president_id;
    }
    public Equipe(){
        
    }

    public int getIdequipe() {
        return idequipe;
    }

    public void setIdequipe(int idequipe) {
        this.idequipe = idequipe;
    }

    public String getPays_equipe() {
        return pays_equipe;
    }

    public void setPays_equipe(String pays_equipe) {
        this.pays_equipe = pays_equipe;
    }

    public int getCoach_id() {
        return coach_id;
    }

    public void setCoach_id(int coach_id) {
        this.coach_id = coach_id;
    }

    public int getPresident_id() {
        return president_id;
    }

    public void setPresident_id(int president_id) {
        this.president_id = president_id;
    }
        public String getidequipeNomp(){
        return idequipe+" "+pays_equipe;}
    
}
