/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.GUI;

import static java.awt.PageAttributes.MediaType.C;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableView;

import kids.project.entities.enfant;
import kids.project.entities.participation;

import kids.project.entities.personne;
import kids.project.services.Session;
import kids.project.services.services_event;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ParticiperController implements Initializable {

    @FXML
    private Button enregistrerP;
    private Button xx;
     ObservableList<enfant> oblist = FXCollections.observableArrayList();
     services_event sr=new services_event();
     
    public ComboBox<String> names;
    private String nom;
    private String date;
    private double prix;
    private String desc;
    private String type;

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }
    private String lieu;
    private int idEvent ;
    personne p = Session.GetSession();

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
    
    
    
  
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
//         ObservableList<String> Name_Listes = null;
//        try {
//            Name_Listes = FXCollections.observableArrayList(sr.afficherenfant(p.getId()));
//        } catch (SQLException ex) {
//            Logger.getLogger(ParticiperController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//           names.setItems(Name_Listes);
      
        // TODO
    }    
       
//        oblist = (ObservableList<enfant>) sr.afficherenfant();
//        nom_enfant.setCellValueFactory( new PropertyValueFactory<>("nom_enfant"));
//        prenom_enfant.setCellValueFactory( new PropertyValueFactory<>("prenom_enfant"));

    private void select(ActionEvent event) {
       
        
//        ObservableList<String> listeEnfant = FXCollections.observableArrayList(enfant.afficherenfant());
//      selectE.setItems(listeEnfant);
        
    }

    @FXML
    private void enregistrer(ActionEvent event) throws IOException, SQLException {
        
    int idE=   sr.getId(names.getValue());
        sr.enregistrer(idE,idEvent);
         TrayNotification tray =new TrayNotification();
            tray.setTitle("Succès");
        tray.setMessage("Participation réussite!");
        tray.setAnimationType(AnimationType.POPUP);
        tray.setNotificationType(NotificationType.INFORMATION);
        tray.showAndWait();
    }

    


   
    
}
