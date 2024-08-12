
package vue;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;//gerer les donnees d'un composant JTable
import java.sql.*;
import javafoot.model.*;
import javafoot.controleur.*;
public class FormArbitre extends JFrame implements ActionListener{
     JLabel lIdarbitre,lNom,lPrenom,lposte;
    JTextField tIdarbitre,tNom,tPrenom,tposte,tkurondeza;
     JButton enr,vis,ini,mis,rech,del;
      JComboBox listeposte;
    String[] poste={"arbitre-central","arbitre-assistants","quatrieme-arbitre","arbitre-video"};
    
     ArrayList<Arbitre> listeArbitre= new ArrayList();
     JTable tablearbitre;
     
     private final DefaultTableModel model;//la classe qui implemente un modele de table par defaut pour un JTable.
      Arbitre co=null;
               
     public FormArbitre(){ 
          lIdarbitre=new JLabel("ID Arbitre");
        lIdarbitre.setBounds(10,30,100,30);
        this.getContentPane().add(lIdarbitre);
        
         tIdarbitre=new JTextField();
        tIdarbitre.setBounds(120,30,100,30);
        this.getContentPane().add(tIdarbitre);
         
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
        
        lposte=new JLabel("Poste");
        lposte.setBounds(10,150,120,30);
        this.getContentPane().add(lposte);  
    
        listeposte=new JComboBox(poste);
       listeposte .setBounds(120,150,100,30);
       listeposte.addActionListener(this);
         this.getContentPane().add(listeposte);
         
          enr=new JButton("Enregistrer");
         enr.setBounds(10,220,80,30);
         enr.addActionListener(this);
         this.getContentPane().add(enr);
         
        vis=new JButton("Visualiser");
         vis.setBounds(110,220,80,30);
          vis.addActionListener(this);
         this.getContentPane().add(vis);
         
         ini=new JButton("Initialiser");
         ini.setBounds(210,220,80,30);
          ini.addActionListener(this);
         this.getContentPane().add(ini);
         
               mis=new JButton("Mise A Jour");
         mis.setBounds(310,220,80,30);
          mis.addActionListener(this);
         this.getContentPane().add(mis);
         
                rech=new JButton("Recherche");
         rech.setBounds(410,220,80,30);
         rech.addActionListener(this);
         this.getContentPane().add(rech);
         
                   del=new JButton("Supprime");
         del.setBounds(510,220,80,30);
         del.addActionListener(this);
         this.getContentPane().add(del);
         
                 model=new DefaultTableModel();
         model.addColumn("idarbitre");
           model.addColumn("nom");
            model.addColumn("prenom");
             model.addColumn("poste");
          
          
          this.getContentPane().setLayout(null);
   
     }  public void actionPerformed(ActionEvent e){
         if(e.getSource ()==enr){
         int idarbitre=Integer.valueOf(tIdarbitre.getText());
           String nom=tNom.getText();
            String prenom=tPrenom.getText();
            String poste=listeposte.getSelectedItem().toString();
     
            co=new Arbitre(idarbitre,nom,prenom,poste);
            Factory.setArbitre(co);
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
                        co = Factory.getRecharb(rech);
                        if(co != null){
                            tIdarbitre.setText(String.valueOf(co.getIdarbitre()));
                            tNom.setText(co.getNom());
                            tPrenom.setText(co.getPrenom());
                            listeposte.setSelectedItem(co.getPoste());
                         
                        }
                    }  
             else if(e.getSource()==mis){
                int ident = Integer.valueOf(tIdarbitre.getText());
                            String nom = tNom.getText();
                            String prenom = tPrenom.getText();
                            String poste = listeposte.getSelectedItem().toString();
                            co = new Arbitre(ident,nom,prenom,poste);
                            Factory.modifarb(co,Integer.valueOf(tIdarbitre.getText()));
                            }  else{
                            if(e.getSource()==del){
                                if(co != null){
                                  String msg = "Souhaitez-vous supprimer "+co.getNom()+" - "+co.getPrenom();
                                  int rep = JOptionPane.showConfirmDialog(this, msg);
                                  if(rep==0){
                                        Factory.getDelarb(co);
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
       listeArbitre= Factory.getArbitre();
       for(Arbitre co:listeArbitre){
           model.addRow(new Object[]{
        co.getIdarbitre(),co.getNom() ,co.getPrenom(),co.getPoste()});
           }
       tablearbitre = new JTable(model);
       JScrollPane p=new JScrollPane(tablearbitre);
       p.setBounds(60,320,300,100);
       this.getContentPane().add(p);
       }
public void initialiser(){
 tIdarbitre.setText("");
tNom.setText("");    
tPrenom.setText("");



   }          
          
     }
    
    
    
    
    
    
    
    
    
    
    


    
    

