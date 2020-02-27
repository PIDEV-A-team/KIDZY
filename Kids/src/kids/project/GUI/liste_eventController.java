/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author ala
 */
public class liste_eventController implements Initializable {

    @FXML
    private Text text;
    @FXML
    private TableView<?> id_table;
    @FXML
    private TableColumn<?, ?> nom_col;
    @FXML
    private TableColumn<?, ?> date_col;
    @FXML
    private TableColumn<?, ?> prix_col;
    @FXML
    private TableColumn<?, ?> desc_col;
    @FXML
    private TableColumn<?, ?> type_col;
    @FXML
    private TableColumn<?, ?> lieu_col;
    @FXML
    private TableColumn<?, ?> button_id;
    @FXML
    private Button ajouterE;
    @FXML
    private Button id_modif;
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
        // TODO
    }    

    @FXML
    private void supprimer(ActionEvent event) {
    }

    @FXML
    private void ajouter(ActionEvent event) {
    }

    @FXML
    private void modifier(ActionEvent event) {
    }

    @FXML
    private void acceuil(ActionEvent event) {
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
    private void delete(ActionEvent event) {
    }

    @FXML
    private void updateEvent(ActionEvent event) {
    }
    
}
