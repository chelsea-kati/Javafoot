
package javafoot.controleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.sql.*;
import javafoot.model.*;



public class Factory {
       public static Connection conn = null;
    public static Statement stm;
    public static PreparedStatement pstmet = null;
    public static ResultSet rs = null;

    public static Connection getConnection() {
        String serveur = "localhost";
        int port = 3308;
        String database = "javafoot";
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://" + serveur + ":" + port + "/" + database;
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("connected");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
        //Get & Set pour le Formulaire Coach
    public static void setCoach(Coach co) {
        try {
            conn = getConnection();

            pstmet = conn.prepareStatement("insert into javafoot.coach(idcoach,nom,prenom,age,nationalite) values(?,?,?,?,?)");

            pstmet.setInt(1, co.getIdcoach());
            pstmet.setString(2, co.getNom());
            pstmet.setString(3, co.getPrenom());
            pstmet.setString(4, co.getAge());
            pstmet.setString(5, co.getNationalite());

            pstmet.executeUpdate();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }

    public static ArrayList<Coach> getCoach() {
        ArrayList<Coach> lic = new ArrayList();
        Coach co = null;
        try {
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from javafoot.coach");
            while (rs.next()) {
                co = new Coach();
                co.setIdcoach(rs.getInt("idcoach"));
                co.setNom(rs.getString("nom"));
                co.setPrenom(rs.getString("prenom"));
                co.setAge(rs.getString("age"));
                co.setNationalite(rs.getString("nationalite"));
                lic.add(co);
            }
            conn.close();
            stm.close();
        } catch (Exception e) {
            e.printStackTrace();//est utilise lorqu'une exception se produit

            //c'est lorsque il ya une erreur d'execution
        }
        return lic;
    }
    //  Methode pour rechercher dans Coach
    public static Coach getRechcoach(int coa) {
        Coach co = null;
        try {
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from javafoot.coach where idcoach='" + coa + "'");
            if (rs.next()) {
                co = new Coach();
                co.setIdcoach(rs.getInt("idcoach"));
                co.setNom(rs.getString("nom"));
                co.setPrenom(rs.getString("prenom"));
                co.setAge(rs.getString("age"));
                co.setNationalite(rs.getString("nationalite"));
            }
            conn.close();
            stm.close();
            return co;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }
        //pour le bouton  modifier pour coach;
     public static void modifCoach(Coach co,int c){
        try{
            conn = getConnection();
            pstmet = conn.prepareStatement("update javafoot.coach set nom=?,prenom=?,age=?,nationalite=? where idcoach='"+c+"'");
//            pstmet.setInt(1, cli.getIdclient());
            pstmet.setString(1, co.getNom());
            pstmet.setString(2, co.getPrenom());
            pstmet.setString(3, co.getAge());
             pstmet.setString(4, co.getNationalite());
           
            
            pstmet.executeUpdate();
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
    //bouton supprimer sur coach;
      public static void getDelcl(Coach co){
        try{
            conn = getConnection();
            stm = conn.createStatement();
            String requete = "delete from javafoot.coach where idcoach='"+co.getIdcoach()+"'";
            stm.executeUpdate(requete);
            conn.close();
        }
        catch(Exception e){
        }
        }
    
    
     //Get & Set pour le Formulaire President
    public static void setPresident(PresidentEquipe pre) {
        try {
            conn = getConnection();

            pstmet = conn.prepareStatement("insert into javafoot.president(idpresident,nom,prenom,email) values(?,?,?,?)");

            pstmet.setInt(1, pre.getIdpresident());
            pstmet.setString(2, pre.getNom());
            pstmet.setString(3, pre.getPrenom());
            pstmet.setString(4, pre.getEmail());
 
            pstmet.executeUpdate();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }

    public static ArrayList<PresidentEquipe> getPresident() {
        ArrayList<PresidentEquipe> lic = new ArrayList();
        PresidentEquipe pre = null;
        try {
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from javafoot.president");
            while (rs.next()) {
                pre = new PresidentEquipe();
                pre.setIdpresident(rs.getInt("idpresident"));
                pre.setNom(rs.getString("nom"));
                pre.setPrenom(rs.getString("prenom"));
                pre.setEmail(rs.getString("email"));
                lic.add(pre);
            }
            conn.close();
            stm.close();
        } catch (Exception e) {
            e.printStackTrace();//est utilise lorqu'une exception se produit

            //c'est lorsque il ya une erreur d'execution
        }
        return lic;
    }
    //  Methode pour rechercher dans president;
    public static PresidentEquipe getRechpres(int pres) {
        PresidentEquipe pre = null;
        try {
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from javafoot.president where idpresident='" + pres + "'");
            if (rs.next()) {
                pre = new PresidentEquipe();
                pre.setIdpresident(rs.getInt("idpresident"));
                pre.setNom(rs.getString("nom"));
                pre.setPrenom(rs.getString("prenom"));
                pre.setEmail(rs.getString("email"));

            }
            conn.close();
            stm.close();
            return pre;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }
        //pour le bouton  modifier pour president;
     public static void modifPresident(PresidentEquipe pre,int p){
        try{
            conn = getConnection();
            pstmet = conn.prepareStatement("update javafoot.president set nom=?,prenom=?,email=? where idpresident='"+p+"'");
//            pstmet.setInt(1, cli.getIdclient());
            pstmet.setString(1, pre.getNom());
            pstmet.setString(2, pre.getPrenom());
            pstmet.setString(3, pre.getEmail());

            pstmet.executeUpdate();
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
    //bouton supprimer sur president;
      public static void getDelpres(PresidentEquipe pres){
        try{
            conn = getConnection();
            stm = conn.createStatement();
            String requete = "delete from javafoot.president where idpresident='"+pres.getIdpresident()+"'";
            stm.executeUpdate(requete);
            conn.close();
        }
        catch(Exception e){
        }
        }
    
    
     //Get & Set pour le Formulaire equipe
    public static void setEquipe(Equipe eq) {
        try {
            conn = getConnection();
            pstmet = conn.prepareStatement("insert into javafoot.equipe (idequipe,pays_equipe,coach_id,president_id) values(?,?,?,?)");
            pstmet.setInt(1, eq.getIdequipe());
            pstmet.setString(2, eq.getPays_equipe());
            pstmet.setInt(3, eq. getCoach_id());
            pstmet.setInt(4, eq.getPresident_id());
            pstmet.executeUpdate();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
    public static ArrayList<Equipe> getEquipe() {
        ArrayList<Equipe> lic = new ArrayList();
       Equipe eq = null;
        try {
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from javafoot.equipe ");
            while (rs.next()) {
                eq = new Equipe();
                eq.setIdequipe(rs.getInt("idequipe"));
                eq.setPays_equipe(rs.getString("Pays_equipe"));
                eq.setCoach_id(rs.getInt("coach_id"));
                eq.setPresident_id(rs.getInt("president_id"));
             
                lic.add(eq);
            }
            conn.close();
            stm.close();
        } catch (Exception e) {
        }
        return lic;

    }
       //        Methode pour rechercher dans equipe
    public static Equipe getRechequipe(int ep) {
       Equipe equi = null;
        try {
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from javafoot.equipe where idequipe='" + ep + "'");
            if (rs.next()) {
                equi = new Equipe();
                equi.setIdequipe(rs.getInt("idequipe"));
                equi.setPays_equipe(rs.getString("pays_equipe"));
                equi.setCoach_id(rs.getInt("coach_id"));
                equi.setPresident_id(rs.getInt("president_id"));
            }
            conn.close();
            stm.close();
            return equi;
        } catch (Exception e) {
            return null;
        }
    }
    
    
      //pour le bouton  modifier pour equipe;
     public static void modifEquipe(Equipe eq,int qui){
        try{
            conn = getConnection();
            pstmet = conn.prepareStatement("update javafoot.equipe set pays_equipe=?,coach_id=?,president_id=? where idpresident='"+qui+"'");
//            pstmet.setInt(1, cli.getIdclient());
            pstmet.setString(1, eq.getPays_equipe());
            pstmet.setInt(2, eq.getCoach_id());
            pstmet.setInt(3, eq.getPresident_id());

            pstmet.executeUpdate();
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
    //bouton supprimer sur equipe;
      public static void getDelequipe(Equipe equ){
        try{
            conn = getConnection();
            stm = conn.createStatement();
            String requete = "delete from javafoot.equipe where idequipe='"+equ.getIdequipe()+"'";
            stm.executeUpdate(requete);
            conn.close();
        }
        catch(Exception e){
        }
        }
    
      //Get & Set pour le Formulaire equipe
    public static void setJoueur(Joueur jou) {
        try {
            conn = getConnection();
            pstmet = conn.prepareStatement("insert into javafoot.joueur (idjoueur,nom,prenom,datenaiss,nationalite,position,equipe_id,coach_id) values(?,?,?,?,?,?,?,?)");
            pstmet.setInt(1, jou.getIdjoueur());
            pstmet.setString(2, jou.getNom());
            pstmet.setString(3, jou. getPrenom());
            LocalDate datenaiss=jou.getDatenaissance();
            pstmet.setDate(4,java.sql.Date.valueOf(datenaiss));
            pstmet.setString(5, jou.getNationalite());
            pstmet.setString(6, jou.getPosition());
            pstmet.setInt(7, jou. getEquipe_id());
            pstmet.setInt(8, jou.getCoach_id());
            pstmet.executeUpdate();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
    public static ArrayList<Joueur> getJoueur() {
        ArrayList<Joueur> lic = new ArrayList();
       Joueur jo = null;
        try {
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from javafoot.joueur ");
            while (rs.next()) {
                jo = new Joueur();
                jo.setIdjoueur(rs.getInt("idjoueur"));
                jo.setNom(rs.getString("nom"));
                jo.setPrenom(rs.getString("prenom"));
                jo.setDatenaissance(rs.getDate("datenaiss").toLocalDate());
                jo.setNationalite(rs.getString("nationalite"));
                jo.setPosition(rs.getString("position"));
                jo.setEquipe_id(rs.getInt("equipe_id"));
                jo.setCoach_id(rs.getInt("coach_id"));
             
                lic.add(jo);
            }
            conn.close();
            stm.close();
        } catch (Exception e) {
        }
        return lic;

    }
       //        Methode pour rechercher dans equipe
    public static Joueur getRechjoueur(int jou) {
       Joueur jj = null;
        try {
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from javafoot.joueur where idjoueur='" + jou + "'");
            if (rs.next()) {
                jj = new Joueur();
                jj.setIdjoueur(rs.getInt("idjoueur"));
                jj.setNom(rs.getString("nom"));
                jj.setPrenom(rs.getString("prenom"));
                jj.setDatenaissance(rs.getDate("datenaiss").toLocalDate());
                jj.setNationalite(rs.getString("nationalite"));
                jj.setPosition(rs.getString("position"));
                jj.setEquipe_id(rs.getInt("equipe_id"));
                jj.setCoach_id(rs.getInt("coach_id"));
            }
            conn.close();
            stm.close();
            return jj;
        } catch (Exception e) {
            return null;
        }
    }
    
    
      //pour le bouton  modifier pour joueur;
     public static void modifJoueur(Joueur jj,int j){
        try{
            conn = getConnection();
            pstmet = conn.prepareStatement("update javafoot.joueur set nom=?,prenom=?,position=?,datenaiss=?,nationalite=?,equipe_id=?,coach_id=? where idjoueur='"+j+"'");
//            pstmet.setInt(1, jj.getIdjoueur());
            pstmet.setString(1, jj.getNom());
            pstmet.setString(2, jj.getPrenom());
                pstmet.setString(3, jj.getPosition());
            LocalDate datenaiss=jj.getDatenaissance();
            pstmet.setDate(4,java.sql.Date.valueOf(datenaiss));
           pstmet.setString(5, jj.getNationalite());
            pstmet.setInt(6, jj.getEquipe_id());
     
            pstmet.setInt(7, jj.getCoach_id());

            pstmet.executeUpdate();
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
    //bouton supprimer sur joueur;
      public static void getDeljoueur(Joueur j){
        try{
            conn = getConnection();
            stm = conn.createStatement();
            String requete = "delete from javafoot.joueur where idjoueur='"+j.getIdjoueur()+"'";
            stm.executeUpdate(requete);
            conn.close();
        }
        catch(Exception e){
        }
        }
       //Get & Set pour le Formulaire arbitre
    public static void setArbitre(Arbitre co) {
        try {
            conn = getConnection();

            pstmet = conn.prepareStatement("insert into javafoot.arbitre(idarbitre,nom,prenom,poste) values(?,?,?,?)");

            pstmet.setInt(1, co.getIdarbitre());
            pstmet.setString(2, co.getNom());
            pstmet.setString(3, co.getPrenom());
            pstmet.setString(4, co.getPoste());


            pstmet.executeUpdate();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }

    public static ArrayList<Arbitre> getArbitre() {
        ArrayList<Arbitre> lic = new ArrayList();
        Arbitre co = null;
        try {
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from javafoot.arbitre");
            while (rs.next()) {
                co = new Arbitre();
                co.setIdarbitre(rs.getInt("idarbitre"));
                co.setNom(rs.getString("nom"));
                co.setPrenom(rs.getString("prenom"));
                co.setPoste(rs.getString("poste"));
               
                lic.add(co);
            }
            conn.close();
            stm.close();
        } catch (Exception e) {
            e.printStackTrace();//est utilise lorqu'une exception se produit

            //c'est lorsque il ya une erreur d'execution
        }
        return lic;
    }
    //  Methode pour rechercher dans arbitre
    public static Arbitre getRecharb(int coa) {
        Arbitre co = null;
        try {
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from javafoot.arbitre where idarbitre='" + coa + "'");
            if (rs.next()) {
                co = new Arbitre();
                co.setIdarbitre(rs.getInt("idarbitre"));
                co.setNom(rs.getString("nom"));
                co.setPrenom(rs.getString("prenom"));
                co.setPoste(rs.getString("poste"));
             
            }
            conn.close();
            stm.close();
            return co;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }
        //pour le bouton  modifier pour coach;
     public static void modifarb(Arbitre co,int c){
        try{
            conn = getConnection();
            pstmet = conn.prepareStatement("update javafoot.arbitre set nom=?,prenom=?,poste=? where idarbitre='"+c+"'");
//            pstmet.setInt(1, cli.getIdclient());
            pstmet.setString(1, co.getNom());
            pstmet.setString(2, co.getPrenom());
            pstmet.setString(3, co.getPoste());
         
           
            
            pstmet.executeUpdate();
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
    //bouton supprimer sur coach;
      public static void getDelarb(Arbitre co){
        try{
            conn = getConnection();
            stm = conn.createStatement();
            String requete = "delete from javafoot.arbitre where idarbitre='"+co.getIdarbitre()+"'";
            stm.executeUpdate(requete);
            conn.close();
        }
        catch(Exception e){
        }
        }
    
     //Get & Set pour le Formulaire secouriste
    public static void setSecouriste(Secouriste co) {
        try {
            conn = getConnection();

            pstmet = conn.prepareStatement("insert into javafoot.secouriste(idsecouriste,nom,prenom,medicaments,outilssecours) values(?,?,?,?,?)");

            pstmet.setInt(1, co.getIdsecouriste());
            pstmet.setString(2, co.getNom());
            pstmet.setString(3, co.getPrenom());
            pstmet.setString(4, co.getMedicaments());
             pstmet.setString(5, co.getOutilssecours());

            pstmet.executeUpdate();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }

    public static ArrayList<Secouriste> getSecouriste() {
        ArrayList<Secouriste> lic = new ArrayList();
        Secouriste co = null;
        try {
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from javafoot.secouriste");
            while (rs.next()) {
                co = new Secouriste();
                co.setIdsecouriste(rs.getInt("idsecouriste"));
                co.setNom(rs.getString("nom"));
                co.setPrenom(rs.getString("prenom"));
                co.setMedicaments(rs.getString("medicaments"));
                co.setOutilssecours(rs.getString("outilssecours"));
               
                lic.add(co);
            }
            conn.close();
            stm.close();
        } catch (Exception e) {
            e.printStackTrace();//est utilise lorqu'une exception se produit

            //c'est lorsque il ya une erreur d'execution
        }
        return lic;
    }
    //  Methode pour rechercher dans secour
    public static Secouriste getRechsec(int coa) {
        Secouriste co = null;
        try {
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from javafoot.secouriste where idsecouriste='" + coa + "'");
            if (rs.next()) {
                co = new Secouriste();
                co.setIdsecouriste(rs.getInt("idsecouriste"));
                co.setNom(rs.getString("nom"));
                co.setPrenom(rs.getString("prenom"));
                co.setMedicaments(rs.getString("medicaments"));
                 co.setOutilssecours(rs.getString("outilssecours"));
             
            }
            conn.close();
            stm.close();
            return co;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }
        //pour le bouton  modifier pour coach;
     public static void modifsec(Secouriste co,int c){
        try{
            conn = getConnection();
            pstmet = conn.prepareStatement("update javafoot.secouriste set nom=?,prenom=?,medicaments=?,outilssecours=? where idsecouriste='"+c+"'");
//            pstmet.setInt(1, cli.getIdclient());
            pstmet.setString(1, co.getNom());
            pstmet.setString(2, co.getPrenom());
            pstmet.setString(3, co.getMedicaments());
             pstmet.setString(4, co.getOutilssecours());
         
           
            
            pstmet.executeUpdate();
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
    //bouton supprimer sur secour;
      public static void getDelsec(Secouriste co){
        try{
            conn = getConnection();
            stm = conn.createStatement();
            String requete = "delete from javafoot.secouriste where idsecouriste='"+co.getIdsecouriste()+"'";
            stm.executeUpdate(requete);
            conn.close();
        }
        catch(Exception e){
        }
        }
    
    
    
    
}
