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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import kids.project.entities.enfant;
import kids.project.entities.personne;
import kids.project.services.Session;
import kids.project.services.services_personne;



/**
 * FXML Controller class
 *
 * @author admin
 */
public class AjouterRecController implements Initializable {
 
        public int  enf ;

    @FXML
    private AnchorPane gridPane;
     
   
 
    @FXML
    private Button contacter;
    @FXML
    public ComboBox<String> combo;
    @FXML
    private TextField description;
    @FXML
    private Button Annuler;
    services_personne sp = new services_personne();
    personne p = Session.GetSession();
        
  
     

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
           }
    }    
    
    
    
   
   

