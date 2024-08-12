
package vue;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;//gerer les donnees d'un composant JTable
import java.sql.*;
import javafoot.model.*;
import javafoot.controleur.*;

public class FormCoach extends JFrame implements ActionListener{
      JLabel lIdcoach,lNom,lPrenom,lage,lnationalite;
    JTextField tIdcoach,tNom,tPrenom,tAge,tkurondeza;
     JButton enr,vis,ini,mis,rech,del;
      JComboBox listenationalites;
    String[] nationalite={"BURUNDAISE","RWANNDAISE","CONGOLAISE","TANAZANIENNE","KENYANNE","NIGERIENNE"};
    
     ArrayList<Coach> listeCoach= new ArrayList();
     JTable tableCoach;
     
     private final DefaultTableModel model;//la classe qui implemente un modele de table par defaut pour un JTable.
      Coach co=null;
               
     public FormCoach(){ 
          lIdcoach=new JLabel("ID Coach");
        lIdcoach.setBounds(10,30,100,30);
        this.getContentPane().add(lIdcoach);
        
         tIdcoach=new JTextField();
        tIdcoach.setBounds(120,30,100,30);
        this.getContentPane().add(tIdcoach);
         
          lNom=new JLabel("Nom");
        lNom.setBounds(10,70,100,30);
        this.getContentPane().add(lNom);
        
         tNom=new JTextField();
        tNom.setBounds(120,70,100,30);
        this.getContentPane().add(tNom);
        
            tkurondeza = new JTextField();// la ou on tape pour chercher l'ID lors de la recherche
    tkurondeza.setBounds(230,30,100,30);
    this.getContentPane().add(tkurondeza);
         
           lPrenom=new JLabel("Prenom");
        lPrenom.setBounds(10,110,100,30);
        this.getContentPane().add(lPrenom);
        
         tPrenom =new JTextField();
       tPrenom.setBounds(120,110,100,30);
        this.getContentPane().add(tPrenom);
        
        lage=new JLabel("Age");
        lage.setBounds(10,150,100,30);
        this.getContentPane().add(lage);  
        
           tAge =new JTextField();
       tAge.setBounds(120,150,100,30);
        this.getContentPane().add(tAge);
        
            lnationalite=new JLabel("Nationalite");
        lnationalite.setBounds(10,190,100,30);
        this.getContentPane().add(lnationalite); 
        
        listenationalites=new JComboBox(nationalite);
       listenationalites .setBounds(120,190,100,30);
       listenationalites.addActionListener(this);
         this.getContentPane().add(listenationalites);
         
          enr=new JButton("Enregistrer");
         enr.setBounds(10,290,80,30);
         enr.addActionListener(this);
         this.getContentPane().add(enr);
         
        vis=new JButton("Visualiser");
         vis.setBounds(110,290,80,30);
          vis.addActionListener(this);
         this.getContentPane().add(vis);
         
         ini=new JButton("Initialiser");
         ini.setBounds(200,290,80,30);
          ini.addActionListener(this);
         this.getContentPane().add(ini);
         
               mis=new JButton("Mise A Jour");
         mis.setBounds(300,290,80,30);
          mis.addActionListener(this);
         this.getContentPane().add(mis);
         
                rech=new JButton("Recherche");
         rech.setBounds(380,290,80,30);
         rech.addActionListener(this);
         this.getContentPane().add(rech);
         
                   del=new JButton("Supprime");
         del.setBounds(450,290,80,30);
         del.addActionListener(this);
         this.getContentPane().add(del);
         
                 model=new DefaultTableModel();
         model.addColumn("idcoach");
           model.addColumn("nom");
            model.addColumn("prenom");
             model.addColumn("age");
             model.addColumn("nationalite");
          
          this.getContentPane().setLayout(null);
   
     }  public void actionPerformed(ActionEvent e){
         if(e.getSource ()==enr){
         int idcoach=Integer.valueOf(tIdcoach.getText());
           String nom=tNom.getText();
            String prenom=tPrenom.getText();
             String age=tAge.getText();
            String nationalite=listenationalites.getSelectedItem().toString();
     
            co=new Coach(idcoach,nom,prenom,age,nationalite);
            Factory.setCoach(co);
     }
     
           else{
             if (e.getSource()==vis){
                 afficher();
             }
             else if(e.getSource()==ini){
                 initialiser();
            
        
 }
             else{ // Bouton rechercher
                    if(e.getSource()==rech){
                        int rech = Integer.valueOf(tkurondeza.getText());
                        co = Factory.getRechcoach(rech);
                        if(co != null){
                            tIdcoach.setText(String.valueOf(co.getIdcoach()));
                            tNom.setText(co.getNom());
                            tPrenom.setText(co.getPrenom());
                            tAge.setText(co.getAge());
                            listenationalites.setSelectedItem(co.getNationalite());
                         
                        }
                    }  
             else if(e.getSource()==mis){
                int ident = Integer.valueOf(tIdcoach.getText());
                            String nom = tNom.getText();
                            String prenom = tPrenom.getText();
                            String age = tAge.getText();
                            String nationalite = listenationalites.getSelectedItem().toString();
                            co = new Coach(ident,nom,prenom,age,nationalite);
                            Factory.modifCoach(co,Integer.valueOf(tIdcoach.getText()));
                            }  else{
                            if(e.getSource()==del){
                                if(co != null){
                                  String msg = "Souhaitez-vous supprimer "+co.getNom()+" - "+co.getPrenom();
                                  int rep = JOptionPane.showConfirmDialog(this, msg);
                                  if(rep==0){
                                        Factory.getDelcl(co);
                                        afficher();
                                        initialiser();
                                  }
                                }
                        }
             }
             }
         }
     }   
                     
           
   public void afficher(){
       model.setRowCount(0);
       listeCoach= Factory.getCoach();
       for(Coach co:listeCoach){
           model.addRow(new Object[]{
        co.getIdcoach(),co.getNom() ,co.getPrenom(),co.getAge(),co.getNationalite()});
           }
       tableCoach = new JTable(model);
       JScrollPane p=new JScrollPane(tableCoach);
       p.setBounds(60,320,300,100);
       this.getContentPane().add(p);
       }
public void initialiser(){
 tIdcoach.setText("");
tNom.setText("");    
tPrenom.setText("");
tAge.setText("");


   }          
          
     }
    
    
    
    
    
    
    
    
    
    
    

