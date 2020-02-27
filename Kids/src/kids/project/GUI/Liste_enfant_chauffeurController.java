/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import kids.project.entities.enfantClasse;

/**
 * FXML Controller class
 *
 * @author ferjani
 */
public class Liste_enfant_chauffeurController implements Initializable {

    @FXML
    private ListView<?> liste_view;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void afficher_enfants(ListView.EditEvent<enfantClasse> event) {
        
        
    }
    
}
