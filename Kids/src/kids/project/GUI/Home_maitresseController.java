
package kids.project.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import kids.project.entities.personne;
import kids.project.services.Session;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Home_maitresseController implements Initializable {

    @FXML
    private Button id_admin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void admin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditProfile.fxml"));
                Parent root = loader.load();
                EditProfileController spc = loader.getController();
                personne p =Session.GetSession();
                spc.setNomE(p.getNom());
                spc.setPrenomE(p.getPrenom());
                spc.setNumTE(p.getTel());
                spc.setNcinE(p.getCin());
                id_admin.getScene().setRoot(root);
    }

    @FXML
    private void logoutP(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLLogin.fxml"));
                Parent root = loader.load();
                id_admin.getScene().setRoot(root);
                Session.DestroySession();
    }
    
}
