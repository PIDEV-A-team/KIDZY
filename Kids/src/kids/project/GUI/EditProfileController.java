package kids.project.GUI;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import kids.project.entities.personne;
import kids.project.services.Session;
import kids.project.services.services_personne;

public class EditProfileController implements Initializable {

    @FXML
    private TextField nomE;
    @FXML
    private TextField numTE;
    @FXML
    private TextField prenomE;
    @FXML
    private TextField NcinE;
    @FXML
    private Button valider;
    @FXML
    private Button annuler;
    @FXML
    private Text text;
  private int  enf ;

    public int getEnf() {
        return enf;
    }

    public void setEnf(int enf) {
        this.enf = enf;
    }    personne p = Session.GetSession();
    services_personne sp = new services_personne();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
           System.out.println(enf);
    }

    public String getNomE() {
        return nomE.getText();
    }

    public void setNomE(String nomE) {
        this.nomE.setText(nomE);

    }

    public String getNumTE() {
        return numTE.getText();
    }

    public void setNumTE(String numTE) {
        this.numTE.setText(numTE);
    }

   

    public String getPrenomE() {
        return prenomE.getText();
    }

    public void setPrenomE(String prenomE) {
        this.prenomE.setText(prenomE);
    }

    public String getNcinE() {
        return NcinE.getText();
    }

    public void setNcinE(String NcinE) {
        this.NcinE.setText(NcinE);
    }

    @FXML

    private void valider(ActionEvent event) throws SQLException, IOException {
        personne p1 = new personne(p.getUsername());

        boolean test = sp.modifierProfil(p1, nomE.getText(), prenomE.getText(), NcinE.getText(), numTE.getText());
             back();
            
    }

    @FXML
    private void annuler(ActionEvent event) throws IOException {
      
                
        back();
    }
            private void back() throws IOException {
                 Parent root = null;
        if (p.getRole().equals("Admin")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
            root = loader.load();
        } else if (p.getRole().equals("Parent")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("home_parent.fxml"));
            root = loader.load();
        } else if (p.getRole().equals("Chauffeur")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("home_chauffeur.fxml"));
            root = loader.load();
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("home_maitresse.fxml"));
            root = loader.load();
        }
        prenomE.getScene().setRoot(root);
                 
    }
            
            
            
            
            

}
