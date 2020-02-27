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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import kids.project.entities.event;
import kids.project.services.services_event;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Form_eventController implements Initializable {

    /**
     * Initializes the controller class.
     */
    services_event ev=new services_event();
    @FXML
    private Button enregistrerE;
    @FXML
    private TextField nomE;
    @FXML
    private TextField lieuE;
    @FXML
    private TextField prixE;
    @FXML
    private TextField descE;
    @FXML
    private Button X;
    @FXML
    private Text text;
    @FXML
    private Button annulerE;
    @FXML
    private TextField id_Date;
    @FXML
    private TextField id_type;
    @Override
    public void initialize(URL url, ResourceBundle rb) {}

    @FXML
    private void enregistrer(ActionEvent event) throws IOException, SQLException {
           
        
      String p = prixE.getText();
     double prix =Double.valueOf(p);
        System.out.println( prix);
     //int prix =Integer.parseDo(prixE.getText());
       event e = new event( nomE.getText(),id_Date.getText() ,prix, descE.getText(),id_type.getText(),lieuE.getText());
       
            ev.ajouter(e);
         FXMLLoader loader = new FXMLLoader(getClass().getResource("liste_event.fxml"));
           Parent root = loader.load();
           text.getScene().setRoot(root);    
           
             
     TrayNotification tray =new TrayNotification();
            tray.setTitle("Succès");
        tray.setMessage("Un nouvel événement est ajouté ! ");
        tray.setAnimationType(AnimationType.POPUP);
        tray.setNotificationType(NotificationType.INFORMATION);
        tray.showAndWait();
  
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("liste_event.fxml"));
           Parent root = loader.load();
           text.getScene().setRoot(root);    
    }

    @FXML
    private void annuler(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("liste_event.fxml"));
           Parent root = loader.load();
           text.getScene().setRoot(root); 
    }
        
    
    
    

}
    
    
