
package vue;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;//gerer les donnees d'un composant JTable
import java.sql.*;
import javafoot.model.*;
import javafoot.controleur.*;

public class FormPresident extends JFrame implements ActionListener{
    JLabel lIdpres,lNom,lPrenom,lemail;
    JTextField tIdpres,tNom,tPrenom,temail,tkurondeza;
     JButton enr,vis,ini,mis,rech,del;
    
     ArrayList<PresidentEquipe> listePresident= new ArrayList();
     JTable tablePresident;
     
        private final DefaultTableModel model;//la classe qui implemente un modele de table par defaut pour un JTable.
     PresidentEquipe pre=null;
               
     public FormPresident(){ 
         
          lIdpres=new JLabel("ID President");
        lIdpres.setBounds(10,30,100,30);
        this.getContentPane().add(lIdpres);
        
         tIdpres=new JTextField();
        tIdpres.setBounds(120,30,100,30);
        this.getContentPane().add(tIdpres);
         
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
        
        lemail=new JLabel("Age");
        lemail.setBounds(10,150,100,30);
        this.getContentPane().add(lemail);  
        
           temail =new JTextField();
       temail.setBounds(120,150,100,30);
        this.getContentPane().add(temail);
         
            enr=new JButton("Enregistrer");
         enr.setBounds(10,200,80,30);
         enr.addActionListener(this);
         this.getContentPane().add(enr);
         
        vis=new JButton("Visualiser");
         vis.setBounds(110,200,80,30);
          vis.addActionListener(this);
         this.getContentPane().add(vis);
         
         ini=new JButton("Initialiser");
         ini.setBounds(200,200,80,30);
          ini.addActionListener(this);
         this.getContentPane().add(ini);
         
               mis=new JButton("Mise A Jour");
         mis.setBounds(290,200,80,30);
          mis.addActionListener(this);
         this.getContentPane().add(mis);
         
                rech=new JButton("Recherche");
         rech.setBounds(360,200,80,30);
         rech.addActionListener(this);
         this.getContentPane().add(rech);
         
                   del=new JButton("Supprime");
         del.setBounds(430,200,80,30);
         del.addActionListener(this);
         this.getContentPane().add(del);
         
                 model=new DefaultTableModel();
         model.addColumn("idpresident");
           model.addColumn("nom");
            model.addColumn("prenom");
             model.addColumn("email");

          this.getContentPane().setLayout(null);
         
         
         
     } public void actionPerformed(ActionEvent e){
         
           if(e.getSource ()==enr){
         int idpresident=Integer.valueOf(tIdpres.getText());
           String nom=tNom.getText();
            String prenom=tPrenom.getText();
             String email=temail.getText();

            pre=new PresidentEquipe(idpresident,nom,prenom,email);
            Factory.setPresident(pre);
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
                        pre = Factory.getRechpres(rech);
                        if(pre != null){
                            tIdpres.setText(String.valueOf(pre.getIdpresident()));
                            tNom.setText(pre.getNom());
                            tPrenom.setText(pre.getPrenom());
                            temail.setText(pre.getEmail());
                         
                        }
                    }  
             else if(e.getSource()==mis){
                int ident = Integer.valueOf(tIdpres.getText());
                            String nom = tNom.getText();
                            String prenom = tPrenom.getText();
                            String email = temail.getText();
                            pre = new PresidentEquipe(ident,nom,prenom,email);
                            Factory.modifPresident(pre,Integer.valueOf(tIdpres.getText()));
                            }  else{
                            if(e.getSource()==del){
                                if(pre != null){
                                  String msg = "Souhaitez-vous supprimer "+pre.getNom()+" - "+pre.getPrenom();
                                  int rep = JOptionPane.showConfirmDialog(this, msg);
                                  if(rep==0){
                                        Factory.getDelpres(pre);
                                        afficher();
                                        initialiser();
                                  }
                                }
                        }
             }
          }  } }
      
                      
   public void afficher(){
       model.setRowCount(0);
       listePresident= Factory.getPresident();
       for( PresidentEquipe pre:listePresident){
           model.addRow(new Object[]{
        pre.getIdpresident(),pre.getNom() ,pre.getPrenom(),pre.getEmail()});
           }
       tablePresident = new JTable(model);
       JScrollPane p=new JScrollPane(tablePresident);
       p.setBounds(60,320,300,100);
       this.getContentPane().add(p);
       }
public void initialiser(){
 tIdpres.setText("");
tNom.setText("");    
tPrenom.setText("");
temail.setText("");


   }  
  
}

