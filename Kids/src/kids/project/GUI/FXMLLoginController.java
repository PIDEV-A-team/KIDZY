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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import kids.project.entities.personne;
import kids.project.services.Session;
import kids.project.services.services_personne;

/**
 * FXML Controller class
 *
 * @author ala
 */
public class FXMLLoginController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label erreur;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        erreur.setVisible(false);
    }

    @FXML
    private void login(ActionEvent event) throws SQLException, IOException {
        erreur.setVisible(false);
        services_personne us = new services_personne();
        if (us.checkUser(username.getText(), password.getText())) {
              Session.SessionOn();
            personne U = us.connexion(username.getText());
            Session.SetSession(U);
            if (U.getRole().equals("Admin")) {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
                Parent root = loader.load();
                username.getScene().setRoot(root);

            } else if (U.getRole().equals("Maitre")) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("home_parent.fxml"));
                Parent root = loader.load();
                username.getScene().setRoot(root);
            } else if (U.getRole().equals("Chauffeur")) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("home_chauffeur.fxml"));
                Parent root = loader.load();
                username.getScene().setRoot(root);
            } else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("home_parent.fxml"));
                Parent root = loader.load();
                username.getScene().setRoot(root);
            }

        } else {
            erreur.setVisible(true);
            erreur.setText("Verifier vos données!!");
        }

    }

//    try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLHome.fxml"));
//            Parent root = loader.load();
//            77FXMLHomeController spc = loader.getController();
//
//            77spc.setLpmessage("Binvenue mr / mss " + username.getText());
//            username.getScene().setRoot(root);
//        } catch (IOException ex) {
//            Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
    @FXML
    private void forgetPwd(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLMail.fxml"));
            Parent root = loader.load();

            username.getScene().setRoot(root);

        } catch (IOException ex) {
            Logger.getLogger(FXMLLoginController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
   
    }
}
