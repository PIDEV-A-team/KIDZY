/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.GUI;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.MessageFormat;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Parent;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;

import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import kids.project.entities.event;
import kids.project.entities.participation;

import kids.project.services.services_event;
import kids.project.services.services_part;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class liste_partController implements Initializable {
    private int id ;
services_event ev=new services_event();
    private TextField nom;
    
    @FXML
    private Label textp;
    
    @FXML
    public ListView<String> listP;
    @FXML
    private Button id_retour;
    @FXML
    private Button imprimer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
ObservableList<String> oblist = FXCollections.observableArrayList();
services_part sr=new services_part();
 
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
    }
    
//    public void getList() throws SQLException{
//        oblist =  sr.listepart(id);
//        nom_col.setCellValueFactory( new PropertyValueFactory<>("nom_enfant"));
//        prenom_col.setCellValueFactory( new PropertyValueFactory<>("prenom_enfant"));
//        tabpart.setItems(oblist);
    
    
    
    
//    }
   

    @FXML
    private void retour(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("liste_event.fxml"));
           Parent root = loader.load();
           id_retour.getScene().setRoot(root);   
    }

    @FXML
    private void imprimer(ActionEvent event) {
  
    
    }
}
    
