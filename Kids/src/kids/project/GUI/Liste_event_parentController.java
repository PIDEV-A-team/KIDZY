/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import kids.project.entities.event;
import kids.project.entities.participation;
import kids.project.entities.personne;
import kids.project.services.Session;
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
public class Liste_event_parentController implements Initializable {
     ObservableList<event> oblist = FXCollections.observableArrayList();
           services_event sr=new services_event();

    @FXML
    private TableView<event> id_table;
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
    private Button id_acceuil;
    @FXML
    private Button id_enfant;
    @FXML
    private Button id_emploi;
    @FXML
    private Button id_event;
    @FXML
    private Button id_pay;
    @FXML
    private Button id_reclam;
    @FXML
    private Button id_notif;
    private Button participer;
    @FXML
    private Button id_participer;
    personne p ;
    @FXML
    private Label iduser;

    public String getIduser() {
        return iduser.getText();
    }

    public void setIduser(String iduser) {
        this.iduser.setText(iduser);
    }

    public personne getP() {
        return p;
    }

    public void setP(personne p) {
        this.p = p;
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
             getEvents();
         } catch (SQLException ex) {
             Logger.getLogger(Liste_event_parentController.class.getName()).log(Level.SEVERE, null, ex);
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
    private void acceuil(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("home_parent.fxml"));
           Parent root = loader.load();
           id_acceuil.getScene().setRoot(root);    
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
    private void payer(ActionEvent event) {
    }

    @FXML
    private void reclamer(ActionEvent event) {
    }

    @FXML
    private void notifier(ActionEvent event) {
    }

    @FXML
    private void participer(ActionEvent event) throws IOException, SQLException {
      
      //  System.out.println(per.getUsername());
     event e =id_table.getSelectionModel().getSelectedItem();
     FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("participer.fxml"));
        /* 
         * if "fx:controller" is not set in fxml
         * fxmlLoader.setController(NewWindowController);
         */
   
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Confirmer participation");
               ParticiperController spp = fxmlLoader.getController();
//                 p.setNom(e.getNom_event());
//           p.setDate(e.getDate_event());
//           p.setPrix(e.getPrix_event());
//           p.setDesc(e.getDesc_event());
//           p.setType(e.getType_event());
//           p.setLieu(e.getLieu_event());
spp.setIdEvent(e.getId_event());
              ObservableList<String> Name_Listes = FXCollections.observableArrayList(sr.afficherenfant(p.getUsername()));
           spp.names.setItems(Name_Listes);

              stage.setScene(scene);
        stage.show();
        
     
//     FXMLLoader loader = new FXMLLoader(getClass().getResource("participer.fxml"));
//    Parent root = loader.load();
   // ParticiperController p = loader.getController();
//    System.out.println(e.getNom_event());
//           p.setNom(e.getNom_event());
//           p.setDate(e.getDate_event());
//           p.setPrix(e.getPrix_event());
//           p.setDesc(e.getDesc_event());
//           p.setType(e.getType_event());
//           p.setLieu(e.getLieu_event());
//    
//    Stage stage = new Stage();
//    stage.initStyle(StageStyle.TRANSPARENT);
//    
//    stage.setTitle("confirmation participation");
//    stage.setScene(new Scene(root));
//    stage.show();
//        id_participer.getScene().setRoot(root);  
     
    }
    }  
    

