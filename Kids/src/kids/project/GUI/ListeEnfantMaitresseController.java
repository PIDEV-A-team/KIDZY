/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.GUI;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import kids.project.entities.enfantClasse;
import kids.project.services.ServiceClasse;
import kids.project.services.Session;

/**
 * FXML Controller class
 *
 * @author ferjani
 */
public class ListeEnfantMaitresseController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    ServiceClasse classe = new ServiceClasse();
       ObservableList<String> listeClasse = FXCollections.observableArrayList();
       ObservableList<enfantClasse> liste = FXCollections.observableArrayList();
    @FXML
    private ComboBox<String> combo;
    @FXML
    private ListView<enfantClasse> liste_view;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
          
            System.out.println(Session.GetSession().getUsername());
           listeClasse = FXCollections.observableArrayList(classe.readClasses(Session.GetSession().getUsername()));
            combo.setItems(listeClasse);
              System.out.println(combo.getValue());
               int id =classe.readIdClasse(combo.getValue());
               System.out.println(id);
               System.out.println(combo.getValue());
              
                 
           
        } catch (SQLException ex) {
            Logger.getLogger(ListeEnfantMaitresseController.class.getName()).log(Level.SEVERE, null, ex);
            
            try {
                getList();
            } catch (SQLException ex1) {
                Logger.getLogger(ListeEnfantMaitresseController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
       
        
        
    }    
     public void getList () throws SQLException{   
           int id =classe.readIdClasse(combo.getValue());
          liste = FXCollections.observableArrayList(classe.afficher_enfant(id));
               liste_view.setItems(liste);
               System.out.println(liste);
                
                }
        
    
         
    
}
