
package vue;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;//gerer les donnees d'un composant JTable
import java.sql.*;
import javafoot.model.*;
import javafoot.controleur.*;

public class Formsecouriste extends JFrame implements ActionListener{
    
      JLabel lIdsecouriste,lNom,lPrenom,lmedic,loutils;
    JTextField tIdsecouriste,tNom,tPrenom,tmedic,toutils,tkurondeza;
     JButton enr,vis,ini,mis,rech,del;
      JComboBox listemedic,listeoutils;
    String[] medicaments={"paracetamol","Bronchodilatate","Ibuprofene","Antispasmodique"};
     String[] outils={"planche de transport","oxygene portable","Defibrillateur Autom","thermometre"};
     ArrayList<Secouriste> listesecouriste= new ArrayList();
     JTable tablesecouriste;
     
     private final DefaultTableModel model;//la classe qui implemente un modele de table par defaut pour un JTable.
      Secouriste co=null;
               
     public Formsecouriste(){ 
          lIdsecouriste=new JLabel("ID Secouristee");
        lIdsecouriste.setBounds(10,30,100,30);
        this.getContentPane().add(lIdsecouriste);
        
         tIdsecouriste=new JTextField();
        tIdsecouriste.setBounds(120,30,100,30);
        this.getContentPane().add(tIdsecouriste);
         
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
        
        lmedic=new JLabel("Medicaments");
        lmedic.setBounds(10,150,120,30);
        this.getContentPane().add(lmedic);  
    
        listemedic=new JComboBox(medicaments);
       listemedic .setBounds(120,150,100,30);
       listemedic.addActionListener(this);
         this.getContentPane().add(listemedic);
         
          loutils=new JLabel("Outils-Secours");
        loutils.setBounds(10,190,120,30);
        this.getContentPane().add(loutils);  
    
        listeoutils=new JComboBox(outils);
       listeoutils .setBounds(120,190,100,30);
       listeoutils.addActionListener(this);
         this.getContentPane().add(listeoutils);
         
          enr=new JButton("Enregistrer");
         enr.setBounds(10,250,80,30);
         enr.addActionListener(this);
         this.getContentPane().add(enr);
         
        vis=new JButton("Visualiser");
         vis.setBounds(110,250,80,30);
          vis.addActionListener(this);
         this.getContentPane().add(vis);
         
         ini=new JButton("Initialiser");
         ini.setBounds(210,250,80,30);
          ini.addActionListener(this);
         this.getContentPane().add(ini);
         
               mis=new JButton("Mise A Jour");
         mis.setBounds(310,250,80,30);
          mis.addActionListener(this);
         this.getContentPane().add(mis);
         
                rech=new JButton("Recherche");
         rech.setBounds(410,250,80,30);
         rech.addActionListener(this);
         this.getContentPane().add(rech);
         
                   del=new JButton("Supprime");
         del.setBounds(510,250,80,30);
         del.addActionListener(this);
         this.getContentPane().add(del);
         
                 model=new DefaultTableModel();
         model.addColumn("idsecouriste");
           model.addColumn("nom");
            model.addColumn("prenom");
             model.addColumn("medicaments");
             model.addColumn("outils-secours");
          
          this.getContentPane().setLayout(null);
   
     }  public void actionPerformed(ActionEvent e){
         if(e.getSource ()==enr){
         int idsecouriste=Integer.valueOf(tIdsecouriste.getText());
           String nom=tNom.getText();
            String prenom=tPrenom.getText();
            String medicaments=listemedic.getSelectedItem().toString();
            String outils=listeoutils.getSelectedItem().toString();
     
            co=new Secouriste(idsecouriste,nom,prenom,medicaments,outils);
            Factory.setSecouriste(co);
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
                        co = Factory.getRechsec(rech);
                        if(co != null){
                            tIdsecouriste.setText(String.valueOf(co.getIdsecouriste()));
                            tNom.setText(co.getNom());
                            tPrenom.setText(co.getPrenom());
                            listemedic.setSelectedItem(co.getMedicaments());
                                   listeoutils.setSelectedItem(co.getOutilssecours());
                         
                        }
                    }  
             else if(e.getSource()==mis){
                int ident = Integer.valueOf(tIdsecouriste.getText());
                            String nom = tNom.getText();
                            String prenom = tPrenom.getText();
                            String medicaments = listemedic.getSelectedItem().toString();
                              String outils = listeoutils.getSelectedItem().toString();
                            co = new Secouriste(ident,nom,prenom,medicaments,outils);
                            
                            Factory.modifsec(co,Integer.valueOf(tIdsecouriste.getText()));
                            }  else{
                            if(e.getSource()==del){
                                if(co != null){
                                  String msg = "Souhaitez-vous supprimer "+co.getNom()+" - "+co.getPrenom();
                                  int rep = JOptionPane.showConfirmDialog(this, msg);
                                  if(rep==0){
                                        Factory.getDelsec(co);
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
       listesecouriste= Factory.getSecouriste();
       for(Secouriste co:listesecouriste){
           model.addRow(new Object[]{
        co.getIdsecouriste(),co.getNom() ,co.getPrenom(),co.getMedicaments(),co.getOutilssecours()});
           }
       tablesecouriste = new JTable(model);
       JScrollPane p=new JScrollPane(tablesecouriste);
       p.setBounds(60,340,350,100);
       this.getContentPane().add(p);
       }
public void initialiser(){
 tIdsecouriste.setText("");
tNom.setText("");    
tPrenom.setText("");


   }          
          
    
}
