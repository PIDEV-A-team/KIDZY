/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.GUI;

import static java.awt.PageAttributes.MediaType.C;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import kids.project.entities.enfant;
import kids.project.services.ServiceEnfant;

/**
 * FXML Controller class
 *
 * @author ferjani
 */
public class ListeEnfantEventController implements Initializable {

    @FXML
    private TableColumn<?, ?> col_nom;
    @FXML
    private TableColumn<?, ?> col_prenom;
    
     enfant enfant = new enfant();
    ServiceEnfant ser = new ServiceEnfant();

    public ObservableList<enfant> list = FXCollections.observableArrayList();
    @FXML
    private TableView<enfant> tab;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            list = (ObservableList<enfant>) ser.readAll();
            col_nom.setCellValueFactory(new PropertyValueFactory<>("nom_enfant"));
            col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom_enfant"));          
            tab.setItems(list);
        } catch (SQLException ex) {
            Logger.getLogger(ListeEnfantEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

  

  
    
}
