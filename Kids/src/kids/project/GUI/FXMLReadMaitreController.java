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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import kids.project.entities.personne;
import kids.project.services.Session;
import kids.project.services.services_personne;

/**
 * FXML Controller class
 *
 * @author ala
 */
public class FXMLReadMaitreController implements Initializable {

    ObservableList<personne> oblist = FXCollections.observableArrayList();

    personne per = Session.GetSession();
    services_personne sp = new services_personne();
    @FXML
    private TableView<personne> tableViewAdmin;
    @FXML
    private TableColumn<?, ?> col_nom;
    @FXML
    private TableColumn<?, ?> col_prenom;

    @FXML
    private TableColumn<?, ?> login_user;
    @FXML
    private TableColumn<?, ?> mdp_user;
    @FXML
    private TableColumn<?, ?> cin_usr;
    @FXML
    private TableColumn<?, ?> tel_usr;
    @FXML
    private TableColumn<?, ?> col_roles;

    @FXML
    private TextField Txt_Nom;
    @FXML
    private TextField Txt_Prenom;
    @FXML
    private TextField Txt_Mpd;
    @FXML
    private TextField Txt_Login;
    @FXML
    private TextField Txt_Cin;
    @FXML
    private TextField Txt_Tel;
    @FXML
    private ComboBox<String> Liste_Roles;
    @FXML
    private Label messageUp;
    @FXML
    private Button id_acceuil;
    @FXML
    private Button id_usr;
    @FXML
    private Button id_enfant;
    @FXML
    private Button id_scol;
    @FXML
    private Button id_pay;
    @FXML
    private Button id_event;
    @FXML
    private Button id_reclam;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ListUser();
        try {
            ObservableList<String> Roles_Listes = FXCollections.observableArrayList(sp.readAllRoles());

            Liste_Roles.setItems(Roles_Listes);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLReadMaitreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void AjouterP(ActionEvent event) throws SQLException {
        personne p1;

        p1 = new personne(Txt_Login.getText(), Txt_Mpd.getText(), Txt_Nom.getText(), Txt_Prenom.getText(), Txt_Cin.getText(), Txt_Tel.getText(), Liste_Roles.getValue());

        sp.ajouter1(p1);
        Alert succAddMealAlert = new Alert(Alert.AlertType.INFORMATION);
        succAddMealAlert.setTitle("Ajout d'un utlisateur :");
        succAddMealAlert.setHeaderText("Resultat:");
        succAddMealAlert.setContentText("Utilisateur ajouté!");
        succAddMealAlert.showAndWait();

        ListUser();

        viderP();
//        TrayNotification tray = new TrayNotification();
//        tray.setTitle("Succès");
//        tray.setMessage("Utilisateur Ajouté ! ");
//        tray.setAnimationType(AnimationType.POPUP);
//        tray.setNotificationType(NotificationType.INFORMATION);
//        tray.showAndWait();
    }

    private void ListUser() {

        try {

            oblist = (ObservableList<personne>) sp.readAll();

            login_user.setCellValueFactory(new PropertyValueFactory<>("username"));
            mdp_user.setCellValueFactory(new PropertyValueFactory<>("password"));
            col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            cin_usr.setCellValueFactory(new PropertyValueFactory<>("cin"));
            tel_usr.setCellValueFactory(new PropertyValueFactory<>("tel"));
            col_roles.setCellValueFactory(new PropertyValueFactory<>("role"));

            tableViewAdmin.setItems(oblist);

        } catch (SQLException ex) {
            Logger.getLogger(FXMLReadMaitreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void viderP() {
        Txt_Nom.setText(" ");
        Txt_Prenom.setText(" ");
        Txt_Mpd.setText(" ");
        Txt_Login.setText(" ");
        Txt_Cin.setText(" ");
        Txt_Tel.setText(" ");
        Liste_Roles.setValue(" ");
        messageUp.setText(" ");
    }

    @FXML
    private void EnregistrerP(ActionEvent event) throws SQLException {
        personne p1 = new personne(Txt_Login.getText());

        boolean test = sp.modifierPersonne(p1, Txt_Login.getText(), Txt_Mpd.getText(), Txt_Nom.getText(), Txt_Prenom.getText(), Txt_Cin.getText(), Txt_Tel.getText(), Liste_Roles.getValue());
        if (test) {
            Alert succAddMealAlert = new Alert(Alert.AlertType.INFORMATION);
            succAddMealAlert.setTitle("Modifier un utlisateur :");
            succAddMealAlert.setHeaderText("Modification d'un utlisateur");
            succAddMealAlert.setContentText("voulez vous vraiment modifier les coordonnées de cet utilisateur?");
            succAddMealAlert.showAndWait();

            ListUser();
            viderP();
        }

    }

    @FXML
    private void modifierP(ActionEvent event) {
        personne h1 = tableViewAdmin.getSelectionModel().getSelectedItem();

        Txt_Mpd.setText(h1.getPassword());
        Txt_Login.setText(h1.getUsername());
        Txt_Nom.setText(String.valueOf(h1.getNom()));
        Txt_Prenom.setText(h1.getPrenom());
        Txt_Cin.setText(h1.getCin());
        Txt_Tel.setText(h1.getTel());
        Liste_Roles.setValue(h1.getRole());

    }

    @FXML
    private void acceuil(ActionEvent event) throws IOException {
        Parent root = null;

        if (per.getRole().equals("Admin")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
            root = loader.load();
        } else if (per.getRole().equals("Parent")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("home_parent.fxml"));
            root = loader.load();
        } else if (per.getRole().equals("Chauffeur")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("home_chauffeur.fxml"));
            root = loader.load();
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("home_maitresse.fxml"));
            root = loader.load();
        }
        id_enfant.getScene().setRoot(root);

    }

    @FXML
    private void usr(ActionEvent event) {
    }

    @FXML
    private void enfant(ActionEvent event) {
    }

    @FXML
    private void scolair(ActionEvent event) {
    }

    @FXML
    private void payer(ActionEvent event) {
    }

    @FXML
    private void event(ActionEvent event) {
    }

    @FXML
    private void reclamer(ActionEvent event) {
    }

    @FXML
    private void deleteeP(ActionEvent event) throws SQLException {
        personne pr = tableViewAdmin.getSelectionModel().getSelectedItem();
        if (!pr.equals(null)) {
            sp.deleteP(pr);
            Alert succAddMealAlert = new Alert(Alert.AlertType.INFORMATION);
            succAddMealAlert.setTitle("Suppression d'un utlisateur :");
            succAddMealAlert.setHeaderText("Suppression d'un utlisateur ");
            succAddMealAlert.setContentText("Voulez vous vraiment supprimer cet évenement?");
            succAddMealAlert.showAndWait();

            ListUser();
        }
    }

}
