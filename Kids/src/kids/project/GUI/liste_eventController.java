/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.GUI;


import com.email.durgesh.Email;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PopupControl;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.mail.MessagingException;
import kids.project.entities.event;
import kids.project.services.services_event;
import kids.project.services.services_part;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class liste_eventController implements Initializable {

    @FXML
    private Text text;
    @FXML
    private Button ajouterE;
    @FXML
    private TableView <event> id_table;
     ObservableList<event> oblist = FXCollections.observableArrayList();
     services_event sr=new services_event();
    @FXML
  
    private TableColumn <?,?>nom_col;
    @FXML
    private TableColumn  <?,?>date_col;
    @FXML
    private TableColumn  <?,?>prix_col;
    @FXML
    private TableColumn <?,?>desc_col;
    @FXML
    private TableColumn  <?,?>type_col;
    @FXML
    private TableColumn  <?,?>lieu_col;
    @FXML
    private TableColumn button_id;
    
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
    private TextField chercher;
    @FXML
    private Button listep;
    @FXML
    private Text textL;
    @FXML
    private Button mail;

    /**
//     * Initializes the controller class.
////     * @param url
//     * @param rb
//     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            getEvents();
            
            
            
//        nom_col.setCellValueFactory( new PropertyValueFactory<>("nom_col"));
//        date_col.setCellValueFactory( new PropertyValueFactory<>("date_col"));
//        prix_col.setCellValueFactory( new PropertyValueFactory<>("prix_col"));
//        desc_col.setCellValueFactory( new PropertyValueFactory<>("desc_col"));
//        type_col.setCellValueFactory( new PropertyValueFactory<>("type_col"));
//        lieu_col.setCellValueFactory( new PropertyValueFactory<>("lieu_col"));
//        
//        id_table.setItems(getEvents());
        } catch (SQLException ex) {
            Logger.getLogger(liste_eventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }  
    
    public void getEvents() throws SQLException{
       
        oblist = (ObservableList<event>) sr.afficherevent();
        nom_col.setCellValueFactory( new PropertyValueFactory<>("nom_event"));
        date_col.setCellValueFactory( new PropertyValueFactory<>("date_event"));
        prix_col.setCellValueFactory( new PropertyValueFactory<>("prix_event"));
        desc_col.setCellValueFactory( new PropertyValueFactory<>("desc_event"));
        type_col.setCellValueFactory( new PropertyValueFactory<>("type_event"));
        lieu_col.setCellValueFactory( new PropertyValueFactory<>("lieu_event"));
        id_table.setItems(oblist);
        //System.err.println(oblist);
        
    
    }


    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        
       FXMLLoader loader = new FXMLLoader(getClass().getResource("form_event.fxml"));
           Parent root = loader.load();
           ajouterE.getScene().setRoot(root);     
           
             
                
      
        
    }


    @FXML
    private void acceuil(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
           Parent root = loader.load();
           text.getScene().setRoot(root);
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
    private void delete(ActionEvent event) throws SQLException {
        event e=id_table.getSelectionModel().getSelectedItem();
      
        if (!e.equals(null)){ 
        sr.deleteEvent(e);
        Alert succAddMealAlert = new Alert(Alert.AlertType.INFORMATION);
        succAddMealAlert.setTitle("Confirmer suppression");
        succAddMealAlert.setHeaderText("Confirmer suppression");
        succAddMealAlert.setContentText("Voulez vous vraiment supprimer cet événement?");
        succAddMealAlert.showAndWait();
       // messageUp.setText("Utilisateur supprimé ");
        getEvents();}
        
        
        TrayNotification tray =new TrayNotification();
            tray.setTitle("Succès");
        tray.setMessage("Un événement est supprimé ! ");
        tray.setAnimationType(AnimationType.POPUP);
        tray.setNotificationType(NotificationType.INFORMATION);
        tray.showAndWait();
    }

    @FXML
    private void updateEvent(ActionEvent event) throws IOException {
          event h1=id_table.getSelectionModel().getSelectedItem();
             
       FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierEvent.fxml"));
           Parent root = loader.load();
           ModifierEventController spc =loader.getController();
          
           spc.setNom(h1.getNom_event());
           spc.setDate(h1.getDate_event());
           spc.setPrix(String.valueOf(h1.getPrix_event()));
           spc.setDes(h1.getDesc_event());
           spc.setType(h1.getType_event());
           spc.setLieu(h1.getLieu_event());
            ajouterE.getScene().setRoot(root);
            Alert succAddMealAlert = new Alert(Alert.AlertType.INFORMATION);
        succAddMealAlert.setTitle("Confirmer modification");
        succAddMealAlert.setHeaderText("Confirmer modification");
        succAddMealAlert.setContentText("Voulez vous vraiment modifier cet événement?");
        succAddMealAlert.showAndWait();
           
    }

    @FXML
    private void recherche(ActionEvent event) throws SQLException {
            oblist.clear();
        oblist.addAll(sr.afficherevent().stream().filter((art)
                -> art.getNom_event().toLowerCase().contains(chercher.getText().toLowerCase())
                || art.getDate_event().toLowerCase().contains(chercher.getText().toLowerCase())
                || art.getLieu_event().toLowerCase().contains(chercher.getText().toLowerCase())

        ).collect(Collectors.toList()));
    }

    @FXML
    private void handlebuttonaction(ActionEvent event) throws IOException, SQLException {
        event e =id_table.getSelectionModel().getSelectedItem();
        services_part ss=new services_part();

//        FXMLLoader fxmlLoader = new FXMLLoader();
//        fxmlLoader.setLocation(getClass().getResource("liste_part.fxml"));
  FXMLLoader loader = new FXMLLoader(getClass().getResource("liste_part.fxml"));
          Parent  root = loader.load();
        liste_partController sp =loader.getController();
        sp.setId(e.getId_event());
//        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
//        Stage stage = new Stage();
//        stage.setTitle("Liste des participants");
        ObservableList<String> list = FXCollections.observableArrayList();
             list =  ss.listepart(e.getId_event());
             sp.listP.setItems(list);
    
//        System.out.println(e.getId_event());
//          sp.setId(e.getId_event());
        
//        stage.setScene(scene);
//        stage.show();
    
//    Parent root = (Parent) fxmlLoader.load();
//    
//    Stage stage = new Stage();
//    stage.initStyle(StageStyle.TRANSPARENT);
//    
//    stage.setTitle("liste des participants");
//    stage.setScene(new Scene(root));
//    stage.show();
        textL.getScene().setRoot(root);   
    }

    @FXML
    private void envoyermail(ActionEvent event) throws MessagingException, UnsupportedEncodingException, SQLException {
    String mai = mail.getText();
    services_event ev = new services_event();
    event e = id_table.getSelectionModel().getSelectedItem();
    event t =  ev.affievent(e);
       // a = System.out.println(e.getNom_event(), e.getDate_event(),e.getPrix_event(),e.getDesc_event(), e.getLieu_event(), e.getType_event());
//    String a=user.forgotpasss(mai);
    ArrayList<String> l= new ArrayList<>();
            
            l= sr.mails(); System.out.println(l);
                    
    for (int i=0; i<l.size();i++ ){
         Email email = new Email("maryemelmanai@gmail.com","mariem21");
         System.out.println("");
        email.setFrom("maryemelmanai@gmail.com", "kidzy");
        email.setSubject("événement");
        email.setContent("<h1> un nouvel événement ajouté! </h1>"+t, "text/html");
        String mail=l.get(i);
        email.addRecipient(mail);
        email.send();
}
        Alert succAddMealAlert = new Alert(Alert.AlertType.INFORMATION);
        succAddMealAlert.setTitle("notification mail");
        succAddMealAlert.setHeaderText("MAIL");
        succAddMealAlert.setContentText("Mail envoyé avec succées");
        succAddMealAlert.showAndWait();
    }
    }

    
    
     
    
  
    
    

