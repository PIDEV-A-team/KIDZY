/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.IServices;

import java.sql.SQLException;
import javafx.collections.ObservableList;
import kids.project.entities.enfant;
import kids.project.entities.enfantClasse;

/**
 *
 * @author ferjani
 */
public interface IServicesEnfant<enfant> {

   // void ajouterEnfant(enfant e) throws SQLException;

    public ObservableList<enfantClasse> readAll() throws SQLException;
    public void afficher_Enfant() throws SQLException;
    public void delete(enfant e) throws SQLException;
   public boolean modifierEnfant(enfantClasse e, String nom, String prenom, String date,String lib) throws SQLException;
    
}
