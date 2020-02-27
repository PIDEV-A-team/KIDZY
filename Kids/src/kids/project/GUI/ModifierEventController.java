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
public class ModifierEventController implements Initializable {

    @FXML
    private TextField nomEv;
    @FXML
    private TextField lieuEv;
    @FXML
    private TextField prixEv;
    @FXML
    private TextField descEv;
    @FXML
    private TextField id_Datev;
    @FXML
    private TextField id_typev;
        services_event sr = new services_event();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   
     
   


    
    public void  setNom(String nom){
        this.nomEv.setText(nom);
    
    }
    public void  setLieu(String lieu){
        this.lieuEv.setText(lieu);
    
    }
    public void  setPrix(String n){
        this.prixEv.setText(n);
    
    }
    public void  setDes(String o){
        this.descEv.setText(o);
    
    }
    public void  setDate(String nm){
        this.id_Datev.setText(nm);
    
    }
    public void  setType(String noms){
        this.id_typev.setText(noms);
    
    }

    @FXML
    private void enregistrerEV(ActionEvent event) throws SQLException, IOException {
         event ev=new event(nomEv.getText());
                  String p = prixEv.getText();

 double prix =Double.valueOf(p);
 sr.modifierEvent(ev, nomEv.getText(), id_Datev.getText(),prix, descEv.getText(),  id_typev.getText(),lieuEv.getText());
      FXMLLoader loader = new FXMLLoader(getClass().getResource("liste_event.fxml"));
           Parent root = loader.load();
           nomEv.getScene().setRoot(root); 
           
           
           TrayNotification tray =new TrayNotification();
            tray.setTitle("Succès");
        tray.setMessage("Un événement est mis à jour ! ");
        tray.setAnimationType(AnimationType.POPUP);
        tray.setNotificationType(NotificationType.INFORMATION);
        tray.showAndWait();
    }

    @FXML
    private void annulerEV(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("liste_event.fxml"));
           Parent root = loader.load();
           nomEv.getScene().setRoot(root); 
    }
    
}
