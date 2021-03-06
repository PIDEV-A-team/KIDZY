/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.GUI;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.Duration;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import kids.project.entities.classe;
import kids.project.entities.enfant;
import kids.project.entities.enfantClasse;
import kids.project.entities.personne;
import kids.project.services.ServiceClasse;
import kids.project.services.ServiceEnfant;
import kids.project.services.Session;
import kids.project.services.Upload;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author ferjani
 */
public class AjouterEnfantController implements Initializable {

    @FXML
    private TextField txt_nom;
    @FXML
    private TextField txt_prenom;

    @FXML
    private Button btn_ajouter;
    @FXML
    private Button btn_annuler;
    @FXML
    private TextField txt_image;
    @FXML
    private ComboBox<String> combo_classe;
    @FXML
    private TextField txt_date;

    enfant enfant = new enfant();
    ServiceEnfant ser = new ServiceEnfant();
    ServiceClasse classe = new ServiceClasse();
    @FXML
    private Button importebtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ObservableList<String> listeClasse = FXCollections.observableArrayList(classe.readAllClasses());

            combo_classe.setItems(listeClasse);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLReadMaitreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ajouter_Enfant(ActionEvent event) throws SQLException {
        personne p = Session.GetSession();
        String nomP = txt_nom.getText();
        String prenomP = txt_prenom.getText();
        String date = txt_date.getText();
        String classe =combo_classe.getValue();
        String img = txt_image.getText();
        ServiceEnfant ser = new ServiceEnfant();
        int id_classe = ser.readClasse(classe);
         int id_user=  ser.readIDUSer(p.getUsername());
        enfantClasse ec = new enfantClasse(id_user, id_classe,nomP, prenomP, img, date);
       ser.ajouterEnfant(ec);
        FXMLLoader loader = new FXMLLoader(getClass()
                .getResource("AfficherListeEnfants.fxml"));
        try {
            Parent root = loader.load();
            AfficherListeEnfantsController alc = loader.getController();
            txt_nom.getScene().setRoot(root);
            
               Notifications notificationBuilder = Notifications.create()
                            .title("Enfant ajoutée")
                            .text("Enfant a été ajoutée avec succès")
                            .graphic(null)                     
                            .position(Pos.CENTER)
                            .onAction(new EventHandler<ActionEvent>(){
                               public void handle(ActionEvent event){
                                   System.out.println("Clicked on notification");
                               }
                                  
                            });
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        
    }

    @FXML
    private void annuler(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherListeEnfants.fxml"));
                Parent root = loader.load();
                btn_ajouter.getScene().setRoot(root);
    }

    @FXML
    private void ajouter_image(ActionEvent event) throws IOException {
        
          FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            Upload u = new Upload();
            u.upload(selectedFile);
            txt_image.setText(selectedFile.getName());

        }
        
    }

}
