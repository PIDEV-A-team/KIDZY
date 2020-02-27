package kids.project.GUI;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import kids.project.entities.Facture;
import kids.project.entities.enfantClasse;
import kids.project.reports.facture;
import kids.project.services.FactureService;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * FXML Controller class
 *
 * @author Youssef Mimouni
 */
public class Mes_reglementController implements Initializable {
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
    public TextField idF= new TextField();
    @FXML
    private TextField tf_nom;
    @FXML
    private TextField tf_prenom;
    @FXML
    private TextField tf_date;
    @FXML
    private TextField tf_total;
    @FXML
    private TextField tf_paye;
    @FXML
    private Button btn_imprim;
    @FXML
    private Button btn_payer;
    @FXML
    private Button btn_affcihe1;
     



    public void setIdfacture(String idF)
    {       
    this.idF.setText(idF);    
    }  
            FactureService fs = new FactureService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
                   
            Platform.runLater(() -> {
            });

    } 
    @FXML
    private void afficher(ActionEvent event) throws SQLException{
        Map list = fs.Facture_enfant(Integer.parseInt(idF.getText()));
        enfantClasse ec = (enfantClasse)list.get("enfant");
        Facture f = (Facture)list.get("facture");
            tf_nom.setText(ec.getNom_enfant());
            tf_prenom.setText(ec.getPrenom_enfant());
            tf_date.setText(String.valueOf(f.getDate_facture().toString()));
            tf_paye.setText(f.getpaye().toString());
            tf_total.setText(String.valueOf(f.getTotal()));
            
    }
    @FXML
    private void imprimer(ActionEvent event) throws DocumentException, FileNotFoundException, SQLException{   
        Map list = fs.Facture_enfant(Integer.parseInt(idF.getText()));
        Facture v =(Facture)list.get("facture");    
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(new File("C:\\Users\\Youssef Mimouni\\Desktop\\pdfPI\\imp.pdf")));
        document.open();
        document.add(new Paragraph(fs.afficher(v,Integer.parseInt(idF.getText())))) ;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setContentText("veuillez chercher le pdf dans le dossier suivant C:\\Users\\Youssef Mimouni\\Desktop\\pdfPI");
        alert.showAndWait();
        }
    
    @FXML
    private void paiement(ActionEvent event) throws IOException{
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("StripePayment.fxml"));
                    Parent root = (Parent) Loader.load();
                    Stage st = new Stage();
                    st.setScene(new Scene(root));
                    st.show();

                    StripePaymentController display = Loader.<StripePaymentController>getController();
                    display.setIdfactureSTRIPE(idF.getText());
        
    }
    @FXML
    private void acceuil(ActionEvent event) {
    }

    @FXML
    private void enfant(ActionEvent event) {
    }

    @FXML
    private void emploi(ActionEvent event) {
    }

    @FXML
    private void event(ActionEvent event) {
    }

    @FXML
    private void payer(ActionEvent event) throws IOException {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("StripePayment.fxml"));
                    Parent root = (Parent) Loader.load();
                    Stage st = new Stage();
                    st.setScene(new Scene(root));
                    st.show();
                    StripePaymentController display = Loader.<StripePaymentController>getController();
                    display.setIdfactureSTRIPE(idF.getText());
        
    }

    @FXML
    private void reclamer(ActionEvent event) {
    }

    @FXML
    private void notif(ActionEvent event) {
    }

    @FXML
    private void admin(ActionEvent event){
        
    }

    @FXML
    private void user(MouseEvent event) {
    }


}
