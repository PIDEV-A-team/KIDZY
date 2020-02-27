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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ferjani
 */
public class ModifierEnfantController implements Initializable {

    @FXML
    private TextField txt_nom;
    @FXML
    private TextField txt_prenom;
    @FXML
    private TextField txt_img;
    @FXML
    private ComboBox<?> com_classse;
    @FXML
    private DatePicker txt_date;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
