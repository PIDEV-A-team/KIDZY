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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import kids.project.services.services_personne;

/**
 * FXML Controller class
 *
 * @author ala
 */
public class NewPassController implements Initializable {

    @FXML
    private Button ChangerMdp;
    String username ;
    @FXML
    private TextField NvMdp;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @FXML
    private Label erreur;
    @FXML
    private TextField ConfNvMdp;

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
        if (NvMdp.getText().equals(ConfNvMdp.getText())){
            
        ser.updatePass(username, NvMdp.getText());
          erreur.setText("mot de passe changé ");
           FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLLogin.fxml"));
                Parent root = loader.load();
               
               
               erreur.getScene().setRoot(root);
        }else {
        erreur.setText("mot de passe non confirmé ");}
        
    }
    
    
}
