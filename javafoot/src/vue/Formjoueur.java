
package vue;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
//import com.toedter.calendar.jDateChooser;
import java.text.*;
import java.time.*;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.util.Date;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;//gerer les donnees d'un composant JTable
import java.sql.*;
import java.time.LocalDate;
import javafoot.model.*;
import javafoot.controleur.*;

public class Formjoueur  extends JFrame implements ActionListener{
    JLabel lidjoueur,lnom,lprenom,ldate,lnationa,lposit,lequipid,lcoachid;
    JTextField tidjoueur,tnom,tprenom,tdate,tposit,tkurondeza,tequipeid,tcoachid;
     JButton enr,vis,ini,rech,mis,del;
     
     ArrayList<Joueur> listeJoueur= new ArrayList();
         JComboBox listenationalites,listeequipe,listecoach;
    String[] nationalite={"BURUNDAISE","RWANNDAISE","CONGOLAISE","TANAZANIENNE","KENYANNE","NIGERIENNE"};
    
     JTable tableJoueur;
     private final DefaultTableModel model;
      Joueur jou=null;
      int index=0;//stocke une valeur saisi dans le combobox pour une cle etrangere;
     ArrayList<Equipe> equipeliste= new ArrayList();  
      ArrayList<Coach> coachliste= new ArrayList(); 
               
     public Formjoueur(){
             
          lidjoueur=new JLabel("ID Joueur");
        lidjoueur.setBounds(10,30,100,30);
        this.getContentPane().add(lidjoueur); 
        
          tidjoueur=new JTextField();
        tidjoueur.setBounds(120,30,100,30);
        this.getContentPane().add(tidjoueur);
        
         
          lnom=new JLabel("Nom");
        lnom.setBounds(10,70,100,30);
        this.getContentPane().add(lnom);
        
         tnom=new JTextField();
        tnom.setBounds(120,70,100,30);
        this.getContentPane().add(tnom);
        
         tkurondeza=new JTextField();
        tkurondeza.setBounds(230,30,100,30);
        this.getContentPane().add(tkurondeza);
        
        lprenom=new JLabel("Prenom");
        lprenom.setBounds(10,110,100,30);
        this.getContentPane().add(lprenom);
        
         tprenom =new JTextField();
       tprenom.setBounds(120,110,100,30);
        this.getContentPane().add(tprenom);
        
          ldate=new JLabel("Date");
        ldate.setBounds(10,150,100,30);
        this.getContentPane().add(ldate);  
        
           tdate =new JTextField("yyyy-MM-dd");
       tdate.setBounds(120,150,100,30);
        this.getContentPane().add(tdate);
        
        
        // Récupération de la valeur saisie dans le champ de texte
tdate.addFocusListener(new java.awt.event.FocusAdapter() {
    @Override
    public void focusGained(java.awt.event.FocusEvent evt) {
        if (tdate.getText().equals("yyyy-MM-dd")) {
            tdate.setText("");
        }
    }

    @Override
    public void focusLost(java.awt.event.FocusEvent evt) {
        if (tdate.getText().isEmpty()) {
            tdate.setText("yyyy-MM-dd");
        }
    }
});

// Récupération de la date saisie
tdate.addActionListener(e -> {
    String dateNaissanceStr = tdate.getText();
    if (!dateNaissanceStr.equals("yyyy-MM-dd")) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dateNaissance = LocalDate.parse(dateNaissanceStr, formatter);
            // Faites quelque chose avec la date de naissance
        } catch (DateTimeParseException ex) {
            // Gérez les erreurs de saisie de la date
        }
    }
});
        
        
        
        
        
        
        
        // Ajout d'un listener pour récupérer la valeur saisie au format LocalDate
//tdate.addActionListener(e -> {
//    try {
//        LocalDate dateNaissance = LocalDate.parse(tdate.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//               // Faites quelque chose avec la date de naissance
//    } catch (DateTimeParseException ex) {
//        JOptionPane.showMessageDialog(this, "Format de date invalide, veuillez utiliser le format yyyy-MM-dd", "Erreur", JOptionPane.ERROR_MESSAGE);
//    }
//});
        
        
              lnationa=new JLabel("Nationalite");
        lnationa.setBounds(10,190,100,30);
        this.getContentPane().add(lnationa); 
        
        listenationalites=new JComboBox(nationalite);
       listenationalites .setBounds(120,190,100,30);
       listenationalites.addActionListener(this);
         this.getContentPane().add(listenationalites);
         
                lposit=new JLabel("Position");
        lposit.setBounds(10,230,100,30);
        this.getContentPane().add(lposit);  
        
           tposit =new JTextField();
       tposit.setBounds(120,230,100,30);
        this.getContentPane().add(tposit);
        
                
           lequipid=new JLabel("ID-Equipe");
        lequipid.setBounds(10,270,100,30);
        this.getContentPane().add(lequipid);
         
         
        //appel d'une cle etrangere avec un combo box d'une concatenation qui vient d'une classe Equipe;
        listeequipe=new JComboBox();
        equipeliste=Factory.getEquipe();
        for(Equipe equi: equipeliste)
        {
          listeequipe.addItem(equi.getidequipeNomp());//concatenation;
        }
        listeequipe.setBounds(120,270,100,30);
        listeequipe.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                index= listeequipe.getSelectedIndex();
            }
        }
        );
        this .getContentPane().add(listeequipe);
             
           lcoachid=new JLabel("ID-Coach");
        lcoachid.setBounds(10,310,100,30);
        this.getContentPane().add(lcoachid);
        
        
        
           //appel d'une cle etrangere avec un combo box d'une concatenation qui vient d'une classe coach;
        listecoach=new JComboBox();
        coachliste=Factory.getCoach();
        for(Coach mat: coachliste)
        {
          listecoach.addItem(mat.getIDnomCoach());//concatenation;
        }
        listecoach.setBounds(120,310,100,30);
        listecoach.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                index= listecoach.getSelectedIndex();
            }
        }
        );
        this .getContentPane().add(listecoach); 
        
        
           enr=new JButton("Enregistrer");
         enr.setBounds(10,390,70,30);
         enr.addActionListener(this);
         this.getContentPane().add(enr);
         
        vis=new JButton("Visualiser");
         vis.setBounds(110,390,70,30);
          vis.addActionListener(this);
         this.getContentPane().add(vis);
         
         ini=new JButton("Initialiser");
         ini.setBounds(210,390,70,30);
          ini.addActionListener(this);
         this.getContentPane().add(ini);
         
               mis=new JButton("Mise A Jour");
         mis.setBounds(310,390,70,30);
          mis.addActionListener(this);
         this.getContentPane().add(mis);
         
                rech=new JButton("Recherche");
         rech.setBounds(410,390,70,30);
         rech.addActionListener(this);
        this.getContentPane().add(rech);
        
                del=new JButton("Supprime");
         del.setBounds(510,390,70,30);
         del.addActionListener(this);
        this.getContentPane().add(del);
        
           model=new DefaultTableModel();
         
         model.addColumn("Idjoueur");
           model.addColumn("Nom");
            model.addColumn("Prenom");
             model.addColumn("Date");
              model.addColumn("Nationalite");
           model.addColumn("Position");
            model.addColumn("ID-Equipe");
            model.addColumn("ID-Coach");
        
         this.getContentPane().setLayout(null);
     } //Recuperer les valeurs saisies dans le formulaire;
      public void actionPerformed(ActionEvent e){
          if(e.getSource ()==enr){
          int idjoueur=Integer.valueOf(tidjoueur.getText());
         String nom=tnom.getText();
          String prenom=tprenom.getText();
//          LocalDate datenaiss=LocalDate.parse(tdate.getText());
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateNaissanceDate;
        try {
            dateNaissanceDate = dateFormat.parse(tdate.getText());
            LocalDate datenaiss = dateNaissanceDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            
           String nationalite=listenationalites.getSelectedItem().toString();
            String position=tposit.getText();
            // Recuperer la cle etrangere venant du classe coach et dans equipe;
            int equipe_id=equipeliste.get(index).getIdequipe();
             int coach_id=coachliste.get(index).getIdcoach();      

            jou=new Joueur(idjoueur,nom,prenom,datenaiss,nationalite,position,equipe_id,coach_id);
            Factory.setJoueur(jou);
//            listeCours.add(cour);
     }catch (ParseException ex) {
            // Gérez l'erreur de format de date ici
            ex.printStackTrace();}}
         else{
             if (e.getSource()==vis){
                 afficher();
             }
             else if(e.getSource()==ini){
                 initialiser();
             }else
// Bouton rechercher
                 if(e.getSource()==rech){
                     int rech=Integer.valueOf(tkurondeza.getText());
                     jou=Factory.getRechjoueur(rech);
                     if(jou!=null){
                        tidjoueur.setText(String.valueOf(jou.getIdjoueur()));
                        tnom.setText(jou.getNom());
                        tprenom.setText(jou.getPrenom());
                        tdate.setText(jou.getDatenaissance().toString());
                       listenationalites.setSelectedItem(jou.getNationalite());
                        tposit.setText(jou.getPosition());
                        tequipeid.setText(String.valueOf(jou.getEquipe_id()));
                        tcoachid.setText(String.valueOf(jou.getCoach_id()));      
                     }
                 }
               else if(e.getSource()==mis){
                int ident = Integer.valueOf(tidjoueur.getText());
                            String nom = tnom.getText();
                              String prenom = tprenom.getText();
                            LocalDate datenaiss=LocalDate.parse(tdate.getText());
                        String nationalite=listenationalites.getSelectedItem().toString();
                         String position = tposit.getText();
                          int equipe_id = Integer.valueOf(tequipeid.getText());
                          int coach_id = Integer.valueOf(tcoachid.getText());
                            jou = new Joueur(ident,nom,prenom,datenaiss,nationalite,position,equipe_id,coach_id);
                            Factory.modifJoueur(jou,Integer.valueOf(tidjoueur.getText()));
                            } 
               //bouton supprimer;
               else{
                            if(e.getSource()==del){
                                if(jou != null){
                                  String msg = "Souhaitez-vous supprimer "+jou.getNom()+" - "+jou.getPrenom();
                                  int rep = JOptionPane.showConfirmDialog(this, msg);
                                  if(rep==0){
                                        Factory.getDeljoueur(jou);
                                        afficher();
                                        initialiser();
                                  }
                                }
                        }
             }
             
             
             }
     }
     
       public void afficher(){
       model.setRowCount(0);//mettez le nbre de ligne a 0 pour ne pas avoir les 2 elts semblalbles;
       listeJoueur= Factory.getJoueur();
       for(Joueur cou:listeJoueur){
           model.addRow(new Object[]{
            cou.getIdjoueur(),cou.getNom(),cou.getPrenom(),cou.getDatenaissance(),cou.getNationalite(),cou.getPosition(),cou.getEquipe_id(),cou.getCoach_id()});
           }
       tableJoueur = new JTable(model);
       JScrollPane p=new JScrollPane(tableJoueur);
       p.setBounds(60,450,480,200);
       this.getContentPane().add(p);
       }
   
public void initialiser(){
tidjoueur.setText("");
tnom.setText("");
tprenom.setText("");
tdate.setText("");
tposit.setText("");
tequipeid.setText("");
tcoachid.setText("");


   } 

     }   

