/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.GUI;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.mail.MessagingException;
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
    private Label message;
    @FXML
    private TextField id;
    @FXML
    private Button sendMail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
//      
//    }    
// 
//     public String getId() {
//        return id.getText();
//    }
//
//    public void setId(String id) {
//        this.id.setText(id);
//
    }

    @FXML
    private void envoyerMail(ActionEvent event) throws MessagingException, UnsupportedEncodingException, SQLException, IOException {
            
       FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("FXMLPopapMail.fxml"));
        /* 
         * if "fx:controller" is not set in fxml
         * fxmlLoader.setController(NewWindowController);
         */
   
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Saisir votre mail");
               FXMLPopapMailController spc = fxmlLoader.getController();
                spc.setUsernane(id.getText());
        stage.setScene(scene);
        stage.show();
//            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLPopapMail.fxml"));
//    Parent root = (Parent) fxmlLoader.load();
//   
//    Stage stage = new Stage();
//    stage.initStyle(StageStyle.TRANSPARENT);
//    
//    stage.setTitle("liste des participants");
//    stage.setScene(new Scene(root));
//    stage.show();
        //sendMail.getScene().setRoot(root);   
//			// Construct data
//			String apiKey = "apikey=" + "jMj08sPgSDU-unVcErnJICPpq7lnSRJSx6AnsLzcSy";
//			String message = "&message=" + "This your verification code: "+a;
//			String sender = "&sender=" + "Solidarity with refugees";
//			String numbers = "&numbers=" + "216"+user.getTel(mai);
//			
//			// Send data
//			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
//			String data = apiKey + numbers + message + sender;
//			conn.setDoOutput(true);
//			conn.setRequestMethod("POST");
//			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
//			conn.getOutputStream().write(data.getBytes("UTF-8"));
    
//         mail.setVisible(true);
//        MailText.setVisible(true);
//        String maill = mail.getText();
//        services_personne u = new services_personne();
//         int a=u.Mdp(id.getText());
//         String code =String.valueOf(a);
//         int n =u.tentatives(id.getText());
//          if(n==0){
//          
//          
//          message.setText("vous avez atteint le nombre maximal de tentatives possibles \n Vous etez bloqué");
//          
//          }
//          else{
//    Email email = new Email("montassar43@gmail.com","montassar007");
//        email.setFrom("montassar43@gmail.com", "Kidzy");
//        email.setSubject("Votre Mot de passe");
//        email.setContent("<h1> Votre Code is</h1>"+code, "text/html");
//        email.addRecipient(maill);
//        email.send();
//           FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMConfirm.fxml"));
//                Parent root = loader.load();
//                  
//                FXMConfrimController spc = loader.getController();
//                spc.setUsername(id.getText());
//               mail.getScene().setRoot(root);}
//    }else {
//               message.setText("vous devez choisir Mail ou SMS");
}
    private void backLog () throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLLogin.fxml"));
          Parent  root = loader.load();
        
        message.getScene().setRoot(root);
    }

    @FXML
    private void envoyerSMS(ActionEvent event) throws IOException, SQLException {
         services_personne u = new services_personne();
         int a=u.Mdp(id.getText());
         String code =String.valueOf(a);
         int n =u.tentatives(id.getText());
          if(n==0){
          
          
          message.setText("vous avez atteint le nombre maximal de tentatives possibles \n Vous etez bloqué");
          }else {
			// Construct data
			String apiKey = "apikey=" + "jMj08sPgSDU-unVcErnJICPpq7lnSRJSx6AnsLzcSy";
			String message = "&message=" + "This your verification code: "+a;
			String sender = "&sender=" + "Solidarity with refugees";
			String numbers = "&numbers=" + "216"+u.getTel(id.getText());
			
			// Send data
				HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));}}
    }

