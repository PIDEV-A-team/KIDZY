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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import kids.project.services.services_personne;

/**
 * FXML Controller class
 *
 * @author ala
 */
public class FXMConfrimController implements Initializable {

    @FXML
    private TextField codeConf;
    @FXML
    private Label erreur;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    private String username;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Confimation(ActionEvent event) throws SQLException, IOException {
        services_personne ser = new services_personne();
        int val = Integer.parseInt(codeConf.getText());
        int nbre = ser.tentatives(username);
        int n = nbre;
        if (n > 0) {
            if (ser.checkCode(val)) {
                ser.updateTen(username, 6);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("NewPass.fxml"));
                Parent root = loader.load();
                NewPassController spc = loader.getController();
                spc.setUsername(username);
                codeConf.getScene().setRoot(root);

            }else {
            n-- ;
            erreur.setText("Code invalides ! il vous reste "+n+"tentatives");
            ser.updateTen(username, n);
            
            }

        }else {
           
            erreur.setText("Compte bloqué !!!");
            ser.updateTen(username,0);
            
            }

    }

}
