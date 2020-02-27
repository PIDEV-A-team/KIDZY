/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import kids.project.entities.enfant;
import kids.project.entities.enfantClasse;
import kids.project.services.ServiceClasse;
import kids.project.services.ServiceEnfant;

/**
 * FXML Controller class
 *
 * @author ferjani
 */
public class AfficherListeEnfantsController implements Initializable {

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
    @FXML
    private TableView<enfantClasse> tableau;
    @FXML
    private TableColumn<?, ?> txt_nom;
    @FXML
    private TableColumn<?, ?> txt_prenom;
    @FXML
    private TableColumn<?, ?> txt_classe;
    @FXML
    private TableColumn<?, ?> txt_dateP;
    @FXML
    private TextField txt_search;
    @FXML
    private ComboBox<String> combo_classe;
    @FXML
    private TextField txt_nomm;
    @FXML
    private TextField txt_prenomm;
    @FXML
    private TextField datePick;
    @FXML
    private Button btn_vider;
    @FXML
    private Button btn_enregistrer;
    @FXML
    private Button btn_ajouter;
    @FXML
    private Button btn_supprimer;
    @FXML
    private Button btn_modifier;

    ServiceClasse classe = new ServiceClasse();
    public ObservableList<enfantClasse> liste = FXCollections.observableArrayList();
    enfantClasse enf = new enfantClasse();
    ServiceEnfant ser = new ServiceEnfant();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadListeEnfant();

        try {
            ObservableList<String> listeClasse = FXCollections.observableArrayList(classe.readAllClasses());

            combo_classe.setItems(listeClasse);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLReadMaitreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void acceuil(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader
                .load(getClass().getResource("home.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Ajouter un enfant");
        stage.setScene(scene);
        stage.show();
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
    private void Recherche(ActionEvent event) throws SQLException {
        liste.clear();
        liste.addAll(ser.readAll().stream().filter((art)
                -> art.getNom_enfant().toLowerCase().contains(txt_search.getText().toLowerCase())
                || art.getPrenom_enfant().toLowerCase().contains(txt_search.getText().toLowerCase())
                || art.getLibelle_cla().toLowerCase().contains(txt_search.getText().toLowerCase())
                || art.getDateN_enfant().toLowerCase().contains(txt_search.getText().toLowerCase())
        ).collect(Collectors.toList()));
    }

    @FXML
    private void Vider_enfant() {
        txt_nomm.setText(" ");
        txt_prenomm.setText(" ");
  //      txt_classe.setValue();
        datePick.setText(" ");

    }

    @FXML
    private void Enregistrer_enfant(ActionEvent event) throws SQLException {
        enfantClasse e2 = tableau.getSelectionModel().getSelectedItem();
        String nomP = txt_nomm.getText();
        String prenomP = txt_prenomm.getText();
        String classe = combo_classe.getValue();
        String date = datePick.getText();
        System.out.println(e2.getId_enfant());
        boolean test = ser.modifierEnfant(e2,nomP, prenomP, date,classe);
        if (test) {
            Alert succAddMealAlert = new Alert(Alert.AlertType.INFORMATION);
            succAddMealAlert.setTitle("Modification d'un enfant :");
            succAddMealAlert.setHeaderText("Modification d'un enfant ");
            succAddMealAlert.setContentText("Voulez vous vraiment modifier cet enfant?");
            succAddMealAlert.showAndWait();

            loadListeEnfant();
            Vider_enfant();
        }
    }

    @FXML
    private void Ajouter_enfant(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader
                .load(getClass().getResource("AjouterEnfant.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Ajouter un enfant");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Supprimer_enfant(ActionEvent event) throws SQLException {
        enfantClasse e2 = tableau.getSelectionModel().getSelectedItem();
        if (!e2.equals(null)) {
            ser.deleteE(e2);
            Alert succAddMealAlert = new Alert(Alert.AlertType.INFORMATION);
            succAddMealAlert.setTitle("Suppression d'un enfant :");
            succAddMealAlert.setHeaderText("Suppression d'un enfant ");
            succAddMealAlert.setContentText("Voulez vous vraiment supprimer cet enfant?");
            succAddMealAlert.showAndWait();

            loadListeEnfant();
        }

    }

    @FXML
    private void Modifier_enfant(ActionEvent event) {
        enfantClasse e1 = tableau.getSelectionModel().getSelectedItem();
        txt_nomm.setText(e1.getNom_enfant());
        txt_prenomm.setText(e1.getPrenom_enfant());
          combo_classe.setValue(e1.getLibelle_cla());
        datePick.setText(e1.getDateN_enfant());
    }

    @FXML
    private void loadListeEnfant() {
        try {
           

            liste = (ObservableList<enfantClasse>) ser.readAll();
            txt_nom.setCellValueFactory(new PropertyValueFactory<>("nom_enfant"));
            txt_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom_enfant"));
            txt_classe.setCellValueFactory(new PropertyValueFactory<>("libelle_cla"));
            txt_dateP.setCellValueFactory(new PropertyValueFactory<>("dateN_enfant"));
            tableau.setItems(liste);
        } catch (SQLException ex) {
            Logger.getLogger(AfficherListeEnfantsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
