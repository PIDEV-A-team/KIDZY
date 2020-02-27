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
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import kids.project.entities.enfantClasse;
import kids.project.entities.personne;
import kids.project.services.ServiceEnfant;
import kids.project.services.Session;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Home_parentController implements Initializable {
    
    @FXML
    private Button id_acceuil;
    @FXML
    private Button id_enfant;
    @FXML
    private Button id_emploi;
    @FXML
    private Button id_event;
    @FXML
    private Button id_paie;
    @FXML
    private Button id_reclam;
    @FXML
    private Button id_notif;
    @FXML
    private Button id_admin;
    @FXML
    private ImageView id_user;
    @FXML
    private ImageView id_user1;
    @FXML
    private ImageView id_user11;
    @FXML
    private Button btn_ajouter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void acceuil(ActionEvent event) {
    }

    @FXML
    private void enfant(ActionEvent event) throws IOException, SQLException {
        personne p = Session.GetSession();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Liste_enfant_parent.fxml"));
        Parent root = loader.load();
        Liste_enfant_parentController sp = loader.getController();
        ServiceEnfant ser = new ServiceEnfant();
        System.out.println(p.getId());

        sp.liste = ser.getEnfParent(p.getUsername());

        sp.listeEnfant.setItems(sp.liste);
        id_admin.getScene().setRoot(root);
    }

    @FXML
    private void emploi(ActionEvent event) {
    }

    @FXML
    private void event(ActionEvent event) {
    }

    @FXML
    private void payer(ActionEvent event) {
    }

    @FXML
    private void reclamer(ActionEvent event) {
    }

    @FXML
    private void notif(ActionEvent event) {
    }

    @FXML
    private void admin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditProfile.fxml"));
        Parent root = loader.load();
        EditProfileController spc = loader.getController();
        personne p = Session.GetSession();
        spc.setNomE(p.getNom());
        spc.setPrenomE(p.getPrenom());
        spc.setNumTE(p.getTel());
        spc.setNcinE(p.getCin());
        id_user.getScene().setRoot(root);

    }

    @FXML
    private void user(MouseEvent event) {
    }

    @FXML
    private void logoutP(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLLogin.fxml"));
        Parent root = loader.load();
        id_user.getScene().setRoot(root);
        Session.DestroySession();
    }

    @FXML
    private void Ajouter(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader
                .load(getClass().getResource("Ajouter_son_enfant.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Ajouter un enfant");
        stage.setScene(scene);
        stage.show();
    }
}
