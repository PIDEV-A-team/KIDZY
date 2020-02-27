/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import kids.project.entities.personne;
import kids.project.services.Session;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Home_chauffeurController implements Initializable {

    @FXML
    private Button id_acceuil;
    @FXML
    private Button id_enfant;
    @FXML
    private Button id_emploi;
    @FXML
    private Button id_event;
    @FXML
    private Button id_admin;
    @FXML
    private ImageView id_user;
    @FXML
    private Button logoutCh;
    @FXML
    private ImageView id_user1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void admin(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("EditProfile.fxml"));
                Parent root = loader.load();
                EditProfileController spc = loader.getController();
                personne p =Session.GetSession();
                spc.setNomE(p.getNom());
                spc.setPrenomE(p.getPrenom());
                spc.setNumTE(p.getTel());
                spc.setNcinE(p.getCin());
                logoutCh.getScene().setRoot(root);
                
    }

    @FXML
    private void user(MouseEvent event) {
    }

    @FXML
    private void logoutCh(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLLogin.fxml"));
                Parent root = loader.load();
                logoutCh.getScene().setRoot(root);
                Session.DestroySession();
      
    }
    
}
