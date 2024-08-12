
package vue;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.util.ArrayList;
import javafoot.model.*;

public class Formprincipal  extends JFrame implements ActionListener{
    
       JMenuBar bar;
    JMenu mdonne,mfichier;
    JMenuItem iequip,icoach,ipres,iarbit,isecour,ijoueur,iquit;
    
    public Formprincipal(){
        bar= new JMenuBar();
        mdonne=new JMenu("Tous les formulaires");
        mfichier=new JMenu("Fichier");
        
        iequip=new JMenuItem("Equipe");
        iequip.addActionListener(this);
        icoach=new JMenuItem("Coach");
        icoach.addActionListener(this);
         ipres=new JMenuItem("President");
        ipres.addActionListener(this);
        iarbit =new JMenuItem("Arbitre");
        iarbit.addActionListener(this);
         isecour =new JMenuItem("Secouriste");
        isecour.addActionListener(this);
          ijoueur =new JMenuItem("Joueur");
        ijoueur.addActionListener(this);
       
        
        iquit=new JMenuItem("Quiter");
        
        mdonne.add(iequip);
        mdonne.add(icoach);
        mdonne.add(ipres);
        mdonne.add(iarbit);
        mdonne.add(isecour);
        mdonne.add(ijoueur);
        mfichier.add(iquit);
        
        bar.add(mdonne);
            bar.add(mfichier);
            bar.setBounds(10,50,500,50);
            this.getContentPane().add(bar);//
            this.setLayout(null);}
        
    
            public void actionPerformed(ActionEvent e){

             if(e.getSource()==icoach){
                       FormCoach fo=new FormCoach();
                       fo.setTitle("------FORMULAIRE DES COACH");
                       fo.setSize(500,500);
                       fo.setVisible(true);
                       
             }
             else{
                  if(e.getSource()==ipres){
                       FormPresident foo=new FormPresident();
                       foo.setTitle("------FORMULAIRE DES PRESIDENTS");
                       foo.setSize(500,500);
                       foo.setVisible(true);
                 
                }
             else{
                         if(e.getSource()==iequip){
                       FormEquipe foor=new FormEquipe();
                       foor.setTitle("------FORMULAIRE DES EQUIPE");
                       foor.setSize(500,500);
                       foor.setVisible(true);
                  }
                
             else{
                         if(e.getSource()==ijoueur){
                       Formjoueur foor=new Formjoueur();
                       foor.setTitle("------FORMULAIRE DES JOUEURS");
                       foor.setSize(500,500);
                       foor.setVisible(true);
                  }
                 
                           else{
                         if(e.getSource()==iarbit){
                       FormArbitre foor=new FormArbitre();
                       foor.setTitle("------FORMULAIRE DES ARBITRES");
                       foor.setSize(500,500);
                       foor.setVisible(true);
                  }
                                else{
                         if(e.getSource()==isecour){
                       Formsecouriste foor=new Formsecouriste();
                       foor.setTitle("------FORMULAIRE DES SECOURISTES");
                       foor.setSize(500,500);
                       foor.setVisible(true);
                  }
            }      

            
    
    
}}}}}}
