/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.GUI;

import  com.email.durgesh.Email;
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
import javafx.scene.control.TextField;
import javax.mail.*;
import kids.project.services.services_personne;

/**
 * FXML Controller class
 *<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.geometry.Insets?>
<?import javafx.scene.control.Button?>
<?import javafx.scene.effect.DropShadow?>
<?import javafx.scene.text.Font?>


<Button fx:id="logoutCh" alignment="BASELINE_LEFT" graphicTextGap="22.0" layoutX="647.0" layoutY="14.0" mnemonicParsing="false" onAction="#logoutCh" prefHeight="54.0" prefWidth="51.0" style="-fx-background-color: f7d1bc;" stylesheets="@../../../../../fullpackstyling.css" textFill="#066570" xmlns="http://javafx.com/javafx/8.0.171" xmlns:fx="http://javafx.com/fxml/1">
   <opaqueInsets>
      <Insets />
   </opaqueInsets>
   <padding>
      <Insets left="50.0" />
   </padding>
   <font>
      <Font name="System Italic" size="15.0" />
   </font>
   <effect>
      <DropShadow />
   </effect>
</Button>

 * @author ala
 */
public class FXMLMailController implements Initializable {

    @FXML
    private TextField mail;
    @FXML
    private TextField id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void envoyerMail(ActionEvent event) throws MessagingException, UnsupportedEncodingException, SQLException {
         String maill = mail.getText();
        services_personne u = new services_personne();
    String a=u.Mdp( id.getText());
    Email email = new Email("montassar43@gmail.com","montassar007");
        email.setFrom("montassar43@gmail.com", "Kidzy");
        email.setSubject("Votre Mot de passe");
        email.setContent("<h1> Votre Mot de passe is</h1>"+a, "text/html");
        email.addRecipient(maill);
        email.send();
    }
    private void backLog () throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLLogin.fxml"));
          Parent  root = loader.load();
        
        mail.getScene().setRoot(root);
    }
    
}
