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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import kids.project.entities.enfantClasse;
import kids.project.entities.personne;
import kids.project.services.ServiceEnfant;
import kids.project.services.Session;

/**
 * FXML Controller class
 *
 * @author ferjani
 */
public class Liste_enfant_parentController implements Initializable {
           public int id ;
    @FXML
    private Button id_acceuil;
    @FXML
    private Button id_enfant;
    @FXML
    private Button id_emploi;
    @FXML
    private Button id_event;
    @FXML
    private Button id_pay;
    @FXML
    private Button id_reclam;
    @FXML
    private Button id_notif;
    @FXML
    public ListView<enfantClasse> listeEnfant;

           ObservableList<enfantClasse>liste =FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
       
    }    

    @FXML
    private void acceuil(ActionEvent event) {
    }

    @FXML
    private void enfant(ActionEvent event) {
    }

    @FXML
    private void emploi(ActionEvent event) {
    }

    @FXML
    private void event(ActionEvent event) {
    }

    @FXML
    private void payer(ActionEvent event) {
    }

    @FXML
    private void reclamer(ActionEvent event) {
    }

    @FXML
    private void notifier(ActionEvent event) {
    }
    
}
