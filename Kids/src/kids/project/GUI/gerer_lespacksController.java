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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import kids.project.entities.Frais;
import kids.project.entities.pack;
import kids.project.services.FactureService;
import kids.project.services.FraisService;
import kids.project.services.packservice;
import kids.project.utiles.DataBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class gerer_lespacksController implements Initializable {

    @FXML public TableColumn<pack,String> cl_nom;
    @FXML public TableColumn<pack, Double> cl_prix;
    @FXML public TableColumn<pack,String> cl_desc;


    public TextField tf_nom;
    public TextField tf_description;
    public CheckBox ch_cantine;
    public CheckBox ch_chauffeur;
    public CheckBox ch_garde;
    public CheckBox ch_garde_frais;
    public CheckBox ch_chauffeur_frais;
    public CheckBox ch_cantine_frais;
    public GridPane frais_pane;
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
    @FXML private AnchorPane add_pane;
    @FXML
    private Label text;
    @FXML
    private TableView<pack> packtable ;
    private ObservableList<pack> listepack = FXCollections.observableArrayList();
    packservice ps = new packservice();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {


        try {
            add_pane.setVisible(false);
            frais_pane.setVisible(false);
            listepack.addAll(ps.readAllpack());
            packtable.setEditable(true);
            cl_nom.setCellFactory(TextFieldTableCell.forTableColumn());
            cl_desc.setCellFactory(TextFieldTableCell.forTableColumn());
            cl_prix.setCellFactory((TextFieldTableCell.forTableColumn(new DoubleStringConverter())));

            packtable.setPlaceholder(new Label("pas de pack pour l'affichage, veuillez en ajouter"));
    packtable.refresh();
            packtable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
                if (newSelection != null) {
                    frais_pane.setVisible(true);
                    try {
                        if (ps.get_frais_pack(packtable.getSelectionModel().getSelectedItem().getId_pack()).contains(1)) {
                            ch_cantine_frais.setSelected(true);
                        } else {
                            ch_cantine_frais.setSelected(false);
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    try {
                        if (ps.get_frais_pack(packtable.getSelectionModel().getSelectedItem().getId_pack()).contains(2)) {
                            ch_garde_frais.setSelected(true);
                        } else {
                            ch_garde_frais.setSelected(false);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    try {
                        if (ps.get_frais_pack(packtable.getSelectionModel().getSelectedItem().getId_pack()).contains(3)) {
                            ch_chauffeur_frais.setSelected(true);
                        } else {
                            ch_chauffeur_frais.setSelected(false);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            });


        }catch (SQLException e) {
            e.printStackTrace();
        }
       /* Connection con = DataBase.getInstance().getConnection();
        try {
            ResultSet rs = con.createStatement().executeQuery("select * from pack_payment");
            while (rs.next()){
                listepack.add(new pack(rs.getString("nom_pack"),rs.getDouble("prix_pack"),rs.getString("description_pack")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        ;
        cl_nom.setCellValueFactory(new PropertyValueFactory<>("nom_pack"));
        cl_prix.setCellValueFactory(new PropertyValueFactory<>("prix_pack"));
        cl_desc.setCellValueFactory(new PropertyValueFactory<>("description_pack"));






        packtable.setItems(listepack);

    }
    /*public void showfraispane(ActionEvent actionEvent)throws SQLException {
        if(ps.get_frais_pack(packtable.getSelectionModel().getSelectedItem().getId_pack()).contains(1)){
            ch_cantine_frais.setSelected(true);
        }
        else {
            ch_cantine_frais.setSelected(false);
        }
        if (ps.get_frais_pack(packtable.getSelectionModel().getSelectedItem().getId_pack()).contains(1)){
            ch_garde_frais.setSelected(true);
        }
        else {
            ch_garde_frais.setSelected(false);
        }
        if(ps.get_frais_pack(packtable.getSelectionModel().getSelectedItem().getId_pack()).contains(1)){
            ch_chauffeur_frais.setSelected(true);
        }
        else {
            ch_chauffeur_frais.setSelected(false);
        }

    }*/
    public void buttonadd(ActionEvent actionEvent) throws SQLException {
        List<Integer> l = new ArrayList<Integer>();
        if (ch_cantine.isSelected()){
            l.add(1);
        }
        if (ch_garde.isSelected()){
            l.add(2);
        }
        if (ch_chauffeur.isSelected()){
            l.add(3);
        }

        Double prix = 500.;
        FraisService f = new FraisService();
        for(int s : l) {
            prix=prix+f.getFrais(s).getPrix();
        }

        System.out.println(tf_nom.getText());
        if(tf_nom.getText().equals("")|| tf_description.getText().equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Information Dialog");
            alert.setContentText("Veuillez remplir les champs");
            alert.showAndWait();
        }
        else {
            pack p = new pack(tf_nom.getText(),prix,tf_description.getText());
            int pack = ps.ajouterpack(p);
            if (pack!=0) {
                for (int i=0;i<l.size() ;i++){
                    ps.ajouterfrais_pack(l.get(i), pack);
                }
            }
            packtable.getItems().add(p);
            add_pane.setVisible(false);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("un nouveau pack a été ajouté avec succès");
            alert.showAndWait();
            packtable.refresh();
        }

    }


    public void buttondel(ActionEvent actionEvent) throws SQLException {

        pack selected=packtable.getSelectionModel().getSelectedItem();
        packtable.getItems().remove(packtable.getSelectionModel().getSelectedItem());
        ps.deletepack(selected.getId_pack());
    }
    public void onEditchanged(TableColumn.CellEditEvent<pack, String> packStringCellEditEvent) throws SQLException {
        pack selected = packtable.getSelectionModel().getSelectedItem();
        selected.setNom_pack(packStringCellEditEvent.getNewValue());
        ps.updatenom(selected);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Nom d'un pack existant a été mis à jour avec succès!");
        alert.showAndWait();
    }
    public void pricechanged(TableColumn.CellEditEvent<pack, Double> packDoubleCellEditEvent) throws SQLException {
        pack selected = packtable.getSelectionModel().getSelectedItem();
        selected.setPrix_pack((packDoubleCellEditEvent.getNewValue()));
        ps.updateprix(selected);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Prix d'un pack existant a été mis à jour avec succès!");
        alert.showAndWait();
    }
    public void descchanged(TableColumn.CellEditEvent<pack, String> packStringCellEditEvent) throws SQLException {
        pack selected = packtable.getSelectionModel().getSelectedItem();
        selected.setDescription_pack(packStringCellEditEvent.getNewValue());
        ps.updatedescription(selected);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Une description pack existante a été mise à jour avec succès!");
        alert.showAndWait();
    }
    public void showAddPane(ActionEvent actionEvent) {
        add_pane.setVisible(true);
    }
    FraisService fer =new FraisService();
    public void ch_garde_edit(ActionEvent actionEvent) throws SQLException {
        if (ch_garde_frais.isSelected()==true){
            double newtot = packtable.getSelectionModel().getSelectedItem().getPrix_pack()+fer.getFrais(2).getPrix();
            packtable.getSelectionModel().getSelectedItem().setPrix_pack(newtot);
            ps.updateprix(packtable.getSelectionModel().getSelectedItem());
            ps.ajouterfrais_pack(2,packtable.getSelectionModel().getSelectedItem().getId_pack());
            packtable.refresh();
        }
        if (ch_garde_frais.isSelected()==false){
            double newtot = packtable.getSelectionModel().getSelectedItem().getPrix_pack()-fer.getFrais(2).getPrix();
            packtable.getSelectionModel().getSelectedItem().setPrix_pack(newtot);
            ps.updateprix(packtable.getSelectionModel().getSelectedItem());
            ps.deletePack_Frais(2,packtable.getSelectionModel().getSelectedItem().getId_pack());
            packtable.refresh();
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Prix d'un pack existant a été mis à jour avec succès!");
        alert.showAndWait();

    }

    public void ch_chauffeur_edit(ActionEvent actionEvent) throws SQLException {
        if (ch_chauffeur_frais.isSelected()==true){
            double newtot = packtable.getSelectionModel().getSelectedItem().getPrix_pack()+fer.getFrais(3).getPrix();
            packtable.getSelectionModel().getSelectedItem().setPrix_pack(newtot);
            ps.updateprix(packtable.getSelectionModel().getSelectedItem());
            ps.ajouterfrais_pack(3,packtable.getSelectionModel().getSelectedItem().getId_pack());

            packtable.refresh();
        }
        if (ch_chauffeur_frais.isSelected()==false){
            double newtot = packtable.getSelectionModel().getSelectedItem().getPrix_pack()-fer.getFrais(3).getPrix();
            packtable.getSelectionModel().getSelectedItem().setPrix_pack(newtot);
            ps.updateprix(packtable.getSelectionModel().getSelectedItem());
            ps.deletePack_Frais(3,packtable.getSelectionModel().getSelectedItem().getId_pack());
            packtable.refresh();
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Prix d'un pack existant a été mis à jour avec succès!");
        alert.showAndWait();
    }
    public void ch_cantine_edit(ActionEvent actionEvent) throws SQLException {
        if (ch_cantine_frais.isSelected()==true){
            double newtot = packtable.getSelectionModel().getSelectedItem().getPrix_pack()+fer.getFrais(1).getPrix();
            packtable.getSelectionModel().getSelectedItem().setPrix_pack(newtot);
            ps.updateprix(packtable.getSelectionModel().getSelectedItem());
            ps.ajouterfrais_pack(1,packtable.getSelectionModel().getSelectedItem().getId_pack());

            packtable.refresh();
        }
        if (ch_cantine_frais.isSelected()==false){
            double newtot = packtable.getSelectionModel().getSelectedItem().getPrix_pack()-fer.getFrais(1).getPrix();
            packtable.getSelectionModel().getSelectedItem().setPrix_pack(newtot);
            ps.updateprix(packtable.getSelectionModel().getSelectedItem());
            ps.deletePack_Frais(1,packtable.getSelectionModel().getSelectedItem().getId_pack());
            packtable.refresh();
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Prix d'un pack existant a été mis à jour avec succès!");
        alert.showAndWait();
    }









    @FXML
    private void acceuil(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
        Parent root = loader.load();
        text.getScene().setRoot(root);

    }

    @FXML
    private void user(ActionEvent event) {
    }

    @FXML
    private void reclamer(ActionEvent event) {
    }

    @FXML
    private void event(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("liste_event.fxml"));
           Parent root = loader.load();
           text.getScene().setRoot(root);
    }

    @FXML
    private void enfant(ActionEvent event) {
    }

    @FXML
    private void scolaire(ActionEvent event) {
    }

    @FXML
    private void paiement(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gerer_lespacks.fxml"));
        Parent root = loader.load();
        text.getScene().setRoot(root);
    }

    @FXML
    private void admin(ActionEvent event) {
    }

    @FXML
    private void notifier(ActionEvent event) {
    }



}
