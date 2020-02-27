/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import kids.project.entities.enfant;
import kids.project.entities.personne;
import kids.project.services.Session;
import kids.project.services.services_personne;

/**
 * FXML Controller class
 *
 * @author ala
 */
public class FXMLFormAjoutRecController implements Initializable {

    @FXML
    private AnchorPane gridPane;
   
    @FXML
    private ListView<enfant> ListeEnfant;
    ObservableList<enfant> List = FXCollections.observableArrayList();
                   

 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        services_personne sr = new services_personne();
         personne u=Session.GetSession();
 String use=u.getUsername(); 
 
        try {
            int idd=sr.IDU(use); 
         List = sr.readEnf(idd);
         
         System.out.println(idd);
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLFormAjoutRecController.class.getName()).log(Level.SEVERE, null, ex);
        }
         ListeEnfant.setItems(List);
    }    

    @FXML
    private void valider(ActionEvent event) throws IOException, SQLException {
        services_personne sp =new services_personne();
        enfant e =ListeEnfant.getSelectionModel().getSelectedItem();
         FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterRec.fxml"));
          Parent  root = loader.load();
        AjouterRecController spc = loader.getController();
      
          spc.enf=e.getId_enfant();
         System.out.println("eli hachtna beha "+spc.enf);
         
          System.out.println("jdida +"+spc.enf);
          ObservableList<String> Name_Listes = FXCollections.observableArrayList(sp.readName(spc.enf));

            spc.combo.setItems(Name_Listes);
         
         ListeEnfant.getScene().setRoot(root);

    }
    
}
