/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.GUI;

import com.email.durgesh.Email;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import javax.mail.MessagingException;
import kids.project.services.services_personne;

/**
 * FXML Controller class
 *
 * @author ala
 */
public class FXMLPopapMailController implements Initializable {

    @FXML
    private TextField Textmail;
    @FXML
    private Button sendmail;
    @FXML
    private Label messages;
      
    private String usernane;

    public String getUsernane() {
        return usernane;
    }

    public void setUsernane(String usernane) {
        this.usernane= usernane;
    }

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void send(ActionEvent event) throws MessagingException, UnsupportedEncodingException, IOException, SQLException {
        String maill = Textmail.getText();
        services_personne u = new services_personne();
         int a=u.Mdp(usernane);
         String code =String.valueOf(a);
         int n =u.tentatives(usernane);
          if(n==0){
          
          
          messages.setText("vous avez atteint le nombre maximal de tentatives possibles \n Vous etez bloqué");
          
          }
          else{
    Email email = new Email("maryemelmanai@gmail.com","mariem21");
        email.setFrom("maryemelmanai@gmail.com", "Kidzy");
        email.setSubject("Votre Mot de passe");
        email.setContent("<h1> Votre Code is</h1>"+code, "text/html");
        email.addRecipient(maill);
        email.send();

           FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMConfirm.fxml"));
                Parent root = loader.load();
                  
                FXMConfrimController spc = loader.getController();
                spc.setUsername(usernane);
               Textmail.getScene().setRoot(root);}
    }
}

