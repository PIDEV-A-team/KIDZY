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
       ServiceEnfant s = new ServiceEnfant();
            enfantClasse en = new enfantClasse(57,1,"hh","hh","hh","daedez");       
           int id = s.insertQueryGetId(en);
           System.out.println(id);
//          enfantClasse en = new enfantClasse(57,"hh","hh","hh","hh","hh",1);
        System.out.println(id);
//          ser.ajouterEnfant(en);
       
    }
    
}
