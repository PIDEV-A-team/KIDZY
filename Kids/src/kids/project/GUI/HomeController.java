/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import static jdk.nashorn.internal.runtime.Debug.id;
import kids.project.entities.personne;
import kids.project.services.ServiceParticipation;
import kids.project.services.Session;
import kids.project.utiles.DataBase;

public class HomeController implements Initializable {

    @FXML
    private Button id_acceuil;
    @FXML
    private Button id_user;
    @FXML
    private Button id_reclam;
    @FXML
    private Button id_event;
    @FXML
    private Button id_enfant;
    @FXML
    private Button id_scolaire;
    @FXML
    private Button id_paiement;
    @FXML
    private Button id_admin;
    @FXML
    private Button id_notif;
    private Button id_logout;
    @FXML
    private Label lab_enfant;
    @FXML
    private Label lab_maitresse;
    @FXML
    private Label lab;
    @FXML
    private PieChart chart;

    ObservableList< PieChart.Data> piechartdata;

//    ArrayList< String> p = new ArrayList< String>();
//    ArrayList< Integer> c = new ArrayList< Integer>();
    private Connection con;
    private Statement ste;

    ServiceParticipation sp = new ServiceParticipation();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //  chart();
//        loadData();
//
//        chart.setData(piechartdata);

//       rafraichir();
    }

//    public void rafraichir() {
//        ResultSet stat = null;
//        try {
//            stat = sp.getEnfant();
//        } catch (SQLException ex) {
//            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        chart.getData().clear();
//
//        try {
//            while (stat.next()) {
//                chart.getData().add(new PieChart.Data(stat.getString(1), stat.getDouble(2)));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
//        }

//    }

    
//    public ObservableList<PieChart.Data> chart() {
//        ServiceParticipation p = new ServiceParticipation();
//        ObservableList<PieChart.Data> pieChartData;
//        pieChartData = FXCollections.observableArrayList(
//                new PieChart.Data("Participer", p.getEnfantP()));
//
//        chart.setData(pieChartData);
//        return pieChartData;
//
//    }
    
    
//    public void loadData() {
//
//        String query = "SELECT COUNT(id_enfant)from participation GROUP BY id_event "; 
//
//        piechartdata = FXCollections.observableArrayList();
//
//        con = DataBase.getInstance().getConnection();
//
//        try {
//
//            ResultSet rs = con.createStatement().executeQuery(query);
//            while (rs.next()) {
//
//                piechartdata.add(new PieChart.Data(rs.getString(""), rs.getInt("")));
//                p.add(rs.getString(""));
//                c.add(rs.getInt(""));
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
    
   
    
    
    
    
    @FXML
    private void acceuil(ActionEvent event) {
    }

    @FXML
    private void user(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLReadMaitre.fxml"));
        Parent root = loader.load();
        id_logout.getScene().setRoot(root);
    }

    @FXML
    private void reclamer(ActionEvent event) {
    }

    @FXML
    private void event(ActionEvent event) {
    }

    @FXML
    private void enfant(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherListeEnfants.fxml"));
        Parent root = loader.load();
        id_enfant.getScene().setRoot(root);
    }

    @FXML
    private void scolaire(ActionEvent event) {
    }

    @FXML
    private void paiement(ActionEvent event) {
    }

    @FXML
    private void admin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditProfile.fxml"));
        Parent root = loader.load();
        EditProfileController spc = loader.getController();
        personne p = Session.GetSession();
        spc.setNomE(p.getNom());
        spc.setPrenomE(p.getPrenom());
        spc.setNumTE(p.getTel());

        spc.setNcinE(p.getCin());

        id_logout.getScene().setRoot(root);

    }

    @FXML
    private void notifier(ActionEvent event) {
    }

    private void logout(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLLogin.fxml"));
        Parent root = loader.load();
        id_logout.getScene().setRoot(root);
        Session.DestroySession();
    }

//    @FXML
//    private int nbre_enfant(MouseEvent event) {
//          
//        
//       return nbre ;
//    }
    
    
    @FXML
    private void nbre_enfant(MouseEvent event) {
    }

}
