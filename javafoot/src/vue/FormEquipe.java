
package vue;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;//gerer les donnees d'un composant JTable
import java.sql.*;
import javafoot.model.*;
import javafoot.controleur.*;

public class FormEquipe  extends JFrame implements ActionListener{
     JLabel lidequipe,lpays,lcoachid,lpresid;
    JTextField tidequipe,tpays,tcoachid,tpresid,tkurondeza;
     JButton enr,vis,ini,rech,mis,del;
     ArrayList<Equipe> listeEquipe= new ArrayList();
         JComboBox listecoach,listepresident;
     JTable tableEquipe;
     private final DefaultTableModel model;
      Equipe eq=null;
      int index=0;//stocke une valeur saisi dans le combobox pour une cle etrangere;
     ArrayList<Coach> coachliste= new ArrayList();  
      ArrayList<PresidentEquipe> presidentliste= new ArrayList(); 
               
     public FormEquipe(){
             
          lidequipe=new JLabel("ID Equipe");
        lidequipe.setBounds(10,30,100,30);
        this.getContentPane().add(lidequipe);
        
         tidequipe=new JTextField();
        tidequipe.setBounds(120,30,100,30);
        this.getContentPane().add(tidequipe);
         
          lpays=new JLabel("Nom");
        lpays.setBounds(10,70,100,30);
        this.getContentPane().add(lpays);
        
         tpays=new JTextField();
        tpays.setBounds(120,70,100,30);
        this.getContentPane().add(tpays);
        
         tkurondeza=new JTextField();
        tkurondeza.setBounds(230,30,100,30);
        this.getContentPane().add(tkurondeza);
        
                
           lcoachid=new JLabel("ID-coach");
        lcoachid.setBounds(10,110,100,30);
        this.getContentPane().add(lcoachid);
         
         
        //appel d'une cle etrangere avec un combo box d'une concatenation qui vient d'une classe technicien;
        listecoach=new JComboBox();
        coachliste=Factory.getCoach();
        for(Coach tech: coachliste)
        {
          listecoach.addItem(tech.getIDnomCoach());//concatenation;
        }
        listecoach.setBounds(120,110,100,30);
        listecoach.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                index= listecoach.getSelectedIndex();
            }
        }
        );
        this .getContentPane().add(listecoach);
             
           lpresid=new JLabel("ID-President");
        lpresid.setBounds(10,150,100,30);
        this.getContentPane().add(lpresid);
        
        
        
           //appel d'une cle etrangere avec un combo box d'une concatenation qui vient d'une classe president;
        listepresident=new JComboBox();
        presidentliste=Factory.getPresident();
        for(PresidentEquipe mat: presidentliste)
        {
          listepresident.addItem(mat.getIDnompresident());//concatenation;
        }
        listepresident.setBounds(120,150,100,30);
        listepresident.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                index= listepresident.getSelectedIndex();
            }
        }
        );
        this .getContentPane().add(listepresident); 
        
        
           enr=new JButton("Enregistrer");
         enr.setBounds(10,200,70,30);
         enr.addActionListener(this);
         this.getContentPane().add(enr);
         
        vis=new JButton("Visualiser");
         vis.setBounds(110,200,70,30);
          vis.addActionListener(this);
         this.getContentPane().add(vis);
         
         ini=new JButton("Initialiser");
         ini.setBounds(210,200,70,30);
          ini.addActionListener(this);
         this.getContentPane().add(ini);
         
               mis=new JButton("Mise A Jour");
         mis.setBounds(320,200,70,30);
          mis.addActionListener(this);
         this.getContentPane().add(mis);
         
                rech=new JButton("Recherche");
         rech.setBounds(420,200,70,30);
         rech.addActionListener(this);
        this.getContentPane().add(rech);
        
                del=new JButton("Supprime");
         del.setBounds(500,200,70,30);
         del.addActionListener(this);
        this.getContentPane().add(del);
        
           model=new DefaultTableModel();
         
         model.addColumn("Idequipe");
           model.addColumn("Pays-Equipe");
            model.addColumn("ID-Coach");
             model.addColumn("ID-President");
        
         this.getContentPane().setLayout(null);
     } 
     public void actionPerformed(ActionEvent e){
          if(e.getSource ()==enr){
          int idequipe=Integer.valueOf(tidequipe.getText());//CONVERTIR un attribut de type int;
         String pays_equipe=tpays.getText();
// Recuperer la cle etrangere venant du classe coach et dans president;
            int coach_id=coachliste.get(index).getIdcoach();
            int president_id=presidentliste.get(index).getIdpresident();
            eq=new Equipe(idequipe,pays_equipe,coach_id,president_id);
            Factory.setEquipe(eq);
//            listeCours.add(cour);
     }
else if (e.getSource()==vis){
                 afficher();
             }
             else if(e.getSource()==ini){
                 initialiser();
             }else
// Bouton rechercher
                 if(e.getSource()==rech){
                     int rech=Integer.valueOf(tkurondeza.getText());
                     eq=Factory.getRechequipe(rech);
                     if(eq!=null){
                         tidequipe.setText(String.valueOf(eq.getIdequipe()));
                            tpays.setText(eq.getPays_equipe());
                              tcoachid.setText(String.valueOf(eq.getCoach_id()));
                              tpresid.setText(String.valueOf(eq.getPresident_id()));
                     }
                 }
               else if(e.getSource()==mis){
                int ident = Integer.valueOf(tidequipe.getText());
                            String pays_equipe = tpays.getText();
                            int coach_id = Integer.valueOf(tcoachid.getText());
                            int president_id = Integer.valueOf(tpresid.getText());
                            eq = new Equipe(ident,pays_equipe,coach_id,president_id);
                            Factory.modifEquipe(eq,Integer.valueOf(tidequipe.getText()));
                            } 
               //bouton supprimer;
else if(e.getSource()==del){
                                if(eq != null){
                                  String msg = "Souhaitez-vous supprimer "+eq.getIdequipe()+" - "+eq.getPays_equipe();
                                  int rep = JOptionPane.showConfirmDialog(this, msg);
                                  if(rep==0){// 0 signifie oui;1 non;-1 annuler;
                                        Factory.getDelequipe(eq);
                                        afficher();
                                        initialiser();
                                  }
                                }
                        }
             }
             
             
     
       public void afficher(){
       model.setRowCount(0);//mettez le nbre de ligne a 0 pour ne pas avoir les 2 elts semblalbles;
       listeEquipe= Factory.getEquipe();
       for(Equipe cou:listeEquipe){
           model.addRow(new Object[]{
            cou.getIdequipe(),cou.getPays_equipe(),cou.getCoach_id(),cou.getPresident_id()});
           }
       tableEquipe = new JTable(model);
       JScrollPane p=new JScrollPane(tableEquipe);
       p.setBounds(60,320,300,100);
       this.getContentPane().add(p);
       }
   
public void initialiser(){
tidequipe.setText("");
tpays.setText("");
tcoachid.setText("");
tpresid.setText("");

   } 
    
}
