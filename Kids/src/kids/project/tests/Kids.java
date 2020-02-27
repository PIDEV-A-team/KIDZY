/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kids.project.tests;

import java.sql.SQLException;
import java.util.Date;
import kids.project.entities.enfant;
import kids.project.entities.event;
import kids.project.services.services_event;


public class Kids {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        services_event ser = new services_event();
           // java.util.Date utilDate = new java.util.Date();
       //  java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
    event e1 = new event(42,"dance","2020-02-07", 25.500, "rihem", "jaw", "manzah");
    event e2 = new event("musique", "2020-02-07", 25.500, "rihemss", "jawsss", "manzahsss");
     event e3 = new event("cuisine","2020-02-07", 25.500, "rihemss", "jawsss", "manzahsss");
     event e4 = new event("cuisinesss", "2020-02-07", 25.500, "rihemss", "jawsss", "manzahsss");
     
          //enfant e11= new enfant(15,"mariem", "Rim", "image","2020");
    try {
//     ser.ajouter(e1);
//     ser.ajouter(e4);
//     ser.ajouter(e2);
//     ser.ajouter(e3);
 //System.out.println(  ser.afficherenfant());
        
       

     ser.deleteEvent(e1);
    ser.modifierEvent(e3, "salgggahhh", "2020-02-07", 30.500, "dahmen", "kobi", "manar");
     ser.ajouter(e1);
     ser.ajouter(e2);
//    
     
//       System.out.println( "Liste des evenements triés : "+ser.TriParNom());
//        System.out.println(ser.affichereventparnom("dessin"));
//     event e = new event();
//    
//     System.out.println( e);
//     event e8 = new event();
//   e8= ser.cherchereventT("kobi");
//    System.out.println( e8);
//    
//     event e7 = new event();
//   e7= ser.cherchereventN("musique");
//    System.out.println( e7);
//    
        } catch (SQLException ex) {
            System.out.println("erreur " + ex.getMessage());
        }
    
    }
   
    }
    

