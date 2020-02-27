/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.tests;

import java.sql.SQLException;
import java.util.Observable;
import javafx.collections.ObservableList;
import kids.project.entities.enfant;
import kids.project.entities.enfantClasse;
import kids.project.services.ServiceEnfant;
import kids.project.services.ServiceParticipation;


/**
 *
 * @author ferjani
 */
public class Kids {
    
  
    public static void main(String[] args) throws SQLException {
        
         ServiceEnfant ser = new ServiceEnfant();
         
         ServiceParticipation p = new ServiceParticipation();
          enfant e1 = new enfant(15,"mariem", "Rim", "image","2020");
          int id = ser.readIDUSer("mariem21");
          
          
//          enfantClasse en = new enfantClasse(57,"hh","hh","hh","hh","hh",1);
      //  System.out.println(id);
//          ser.ajouterEnfant(en);
                 

        // System.out.println( p.getEnfantP()); 
         
     //  System.out.println(ser.ListeEnfant(2)); 
        
       enfantClasse e = new enfantClasse();
       System.out.println( ser.getEnfParent("mariem21"));
    
       
       // String ch ="mariem";
//       
//   
//        
//     int nbre= atoi(ch); 
//       
//       if (e.getLibelle_cla().contains("1")) {
//           
//           
//       }
        
        
         
       
    }
    
}
