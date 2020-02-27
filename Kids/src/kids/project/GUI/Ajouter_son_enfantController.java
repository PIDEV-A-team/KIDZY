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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import kids.project.entities.enfant;
import kids.project.entities.enfantClasse;
import kids.project.entities.personne;
import kids.project.services.ServiceClasse;
import kids.project.services.ServiceEnfant;
import kids.project.services.Session;

/**
 * FXML Controller class
 *
 * @author ferjani
 */
public class Ajouter_son_enfantController implements Initializable {

    @FXML
    private Button btn_ajouter;
    @FXML
    private Button btn_annuler;
    @FXML
    private ComboBox<String> combo_classe;
    @FXML
    private TextField txt_image;
    @FXML
    private TextField txt_date;
    @FXML
    private TextField txt_prenom;
    @FXML
    private TextField txt_name;

    enfant enfant = new enfant();
    ServiceEnfant ser = new ServiceEnfant();
    ServiceClasse classe = new ServiceClasse();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            ObservableList<String> listeClasse = FXCollections.observableArrayList(classe.readAllClasses());
            combo_classe.setItems(listeClasse);

        } catch (SQLException ex) {
            Logger.getLogger(Ajouter_son_enfantController.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

    @FXML
    public void ajouter_Enfant(ActionEvent event) throws SQLException, IOException {
        
        personne p = Session.GetSession();
       String nomP = txt_name.getText();
        String prenomP = txt_prenom.getText();
        String date = txt_date.getText();
        String classe =combo_classe.getValue();
        String img = txt_image.getText();
       
        ServiceEnfant ser = new ServiceEnfant();
        int id_user=  ser.readIDUSer(p.getUsername());
        int id_classe = ser.readClasse(classe);
        enfantClasse ec = new enfantClasse(id_user,id_classe,nomP, prenomP, img, date );
        int enfant =ser.insertQueryGetId(ec);
       
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("reglement.fxml"));
        
        Loader.load();

        ReglementController rc = Loader.getController();
        rc.setIdEnfant(String.valueOf(enfant));
        

       
        Stage stage = new Stage();
         Parent root = Loader.getRoot();
         System.out.println(rc);
         Scene scene = new Scene(root);
         stage.setTitle("paiement");
         stage.setScene(scene);
         stage.show();
       
    }

    @FXML
    private void annuler(ActionEvent event) throws IOException {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home_parent.fxml"));
//        Parent root = loader.load();
//        btn_ajouter.getScene().setRoot(root);
int id =  Session.GetSession().getId();
            System.out.println(id);
    }
}
