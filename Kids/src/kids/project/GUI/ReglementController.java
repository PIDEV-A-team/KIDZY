/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.GUI;

import java.io.IOException;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import kids.project.entities.Facture;
import kids.project.entities.enfant;
import kids.project.entities.pack;
import kids.project.services.FactureService;
import kids.project.services.*;
import kids.project.services.packservice;
import com.sun.java.swing.plaf.windows.WindowsDesktopIconUI;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;

import javax.swing.*;
import kids.project.entities.enfantClasse;
import kids.project.entities.personne;

/**
 * FXML Controller class
 *
 * @author Youssef Mimouni
 */
public class ReglementController implements Initializable {
    public GridPane packgrid;
    public ToggleGroup facturetoggle;
    public Label text;
    public ToggleButton mensuelle;
    public ToggleButton annuelle;
    public Label prix1;
    public Label prix2;
    public Label prix3;
    int x=0,y=0,i=0,y1=0;
    packservice ps = new packservice();
    FactureService fs=new FactureService();
    public Button temp ;
    List<pack> packliste = ps.readAllpack();
    public TextField idE= new TextField();
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
    @FXML
    private AnchorPane add_pane;
    @FXML
    private TextField tf_nom;
    @FXML
    private TextField tf_description;
    @FXML
    private CheckBox ch_cantine;
    @FXML
    private CheckBox ch_chauffeur;
    @FXML
    private CheckBox ch_garde;
    @FXML
    private Button show_add_pane;
   

    public ReglementController() throws SQLException {
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        facturetoggle.selectToggle(mensuelle);
          Platform.runLater(() -> {

        //do stuff

    });   
          add_pane.setVisible(false);
        try {

            List<Button> listeboutton= listeboutton();
            for (int i = 0; i < 3; i++) {
                    packgrid.add(listeboutton.get(i), i, 0);
                    listeprix();
                }
      
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public List<Label> listeprix() throws SQLException {
        List<Label> list = new ArrayList<>();
        list.add(prix1);
        list.add(prix2);
        list.add(prix3);
        for (int i =0 ; i<list.size();i++){
            list.get(i).setText(String.valueOf(packliste.get(i).getPrix_pack()));
        }
        return list;
    }

    public List<Button> listeboutton () throws SQLException {
        List<Button> l = new ArrayList<>();
        for (pack item :packliste){
            temp=new Button(item.getNom_pack());
            temp.setMaxSize(251.0, 142.0);
            temp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert a = new Alert(AlertType.INFORMATION);
                a.setTitle("Description pack");
                a.setContentText("Description : "+item.getDescription_pack());
                a.showAndWait();
            }
        });
            l.add(temp);
    }
        return l;
    }

    
    public void setIdEnfant(String idE)
    {       
    this.idE.setText(idE);
    }
    @FXML
    public void valider1(ActionEvent actionEvent ) throws SQLException, IOException {

            if (annuelle.isSelected()==true)
        {           
            Double ancien=   packliste.get(0).getPrix_pack();
            Double newval= (ancien-ancien*0.2);
                int id_pack = packliste.get(0).getId_pack();
        Facture f = new Facture(newval, false); 
        ServiceEnfant ser = new ServiceEnfant();
                
        personne p = Session.GetSession();

        int id_user=  ser.readIDUSer(p.getUsername());
        int facture= fs.ajouterfacture(f,id_pack,Integer.parseInt(idE.getText()),id_user) ;
        List<Integer> l= ps.get_frais(id_pack);
         for (int frais :l){
                fs.ajouterfrais_facture(l.get(l.indexOf(frais)),facture);
            }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setContentText("inscription finalisé");
        alert.showAndWait();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("kids/project/GUI/Mes_reglement.fxml"));    
       
        Parent root = (Parent)fxmlLoader.load(); 
        Mes_reglementController controller = fxmlLoader.<Mes_reglementController>getController();
        controller.setIdfacture(String.valueOf(facture));
                     System.out.println(String.valueOf(facture));

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("paiement");
        stage.setScene(scene);
         stage.show();
                   
                    
                }
            else{
                
                Double ancien=   packliste.get(0).getPrix_pack();
                int id_pack = packliste.get(0).getId_pack();
        Facture f = new Facture(ancien, false); 
        ServiceEnfant ser = new ServiceEnfant();
                
        personne p = Session.GetSession();

        int id_user=  ser.readIDUSer(p.getUsername());
        int facture= fs.ajouterfacture(f,id_pack,Integer.parseInt(idE.getText()),id_user) ;
        List<Integer> l= ps.get_frais(id_pack);
         for (int frais :l){
                fs.ajouterfrais_facture(l.get(l.indexOf(frais)),facture);
            }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setContentText("inscription finalisé");
        alert.showAndWait();
        int id =Integer.parseInt(idE.getText());
                System.out.println(id);
                System.out.println(facture);
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("kids/project/GUI/Mes_reglement.fxml"));    
       
        Parent root = (Parent)fxmlLoader.load(); 
        Mes_reglementController controller = fxmlLoader.<Mes_reglementController>getController();
        controller.setIdfacture(String.valueOf(facture));
                     System.out.println(String.valueOf(facture));

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("paiement");
        stage.setScene(scene);
         stage.show();                
        }  
    }
    @FXML
    public void valider2(ActionEvent actionEvent) throws SQLException, IOException {
         if (annuelle.isSelected()==true)
        {           
            Double ancien=   packliste.get(1).getPrix_pack();
            Double newval= (ancien-ancien*0.2);
                int id_pack = packliste.get(1).getId_pack();
        Facture f = new Facture(newval, false); 
        ServiceEnfant ser = new ServiceEnfant();
                
        personne p = Session.GetSession();

        int id_user=  ser.readIDUSer(p.getUsername());
        int facture= fs.ajouterfacture(f,id_pack,Integer.parseInt(idE.getText()),id_user) ;
        List<Integer> l= ps.get_frais(id_pack);
         for (int frais :l){
                fs.ajouterfrais_facture(l.get(l.indexOf(frais)),facture);
            }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setContentText("inscription finalisé");
        alert.showAndWait();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("kids/project/GUI/Mes_reglement.fxml"));    
       
        Parent root = (Parent)fxmlLoader.load(); 
        Mes_reglementController controller = fxmlLoader.<Mes_reglementController>getController();
        controller.setIdfacture(String.valueOf(facture));
                     System.out.println(String.valueOf(facture));

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("paiement");
        stage.setScene(scene);
         stage.show();
                   
                    
                }
            else{
                
                Double ancien=   packliste.get(1).getPrix_pack();
                int id_pack = packliste.get(1).getId_pack();
        Facture f = new Facture(ancien, false); 
        ServiceEnfant ser = new ServiceEnfant();
                
        personne p = Session.GetSession();

        int id_user=  ser.readIDUSer(p.getUsername());
        int facture= fs.ajouterfacture(f,id_pack,Integer.parseInt(idE.getText()),id_user) ;
        List<Integer> l= ps.get_frais(id_pack);
         for (int frais :l){
                fs.ajouterfrais_facture(l.get(l.indexOf(frais)),facture);
            }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setContentText("inscription finalisé");
        alert.showAndWait();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("kids/project/GUI/Mes_reglement.fxml"));    
       
        Parent root = (Parent)fxmlLoader.load(); 
        Mes_reglementController controller = fxmlLoader.<Mes_reglementController>getController();
        controller.setIdfacture(String.valueOf(facture));
                     System.out.println(String.valueOf(facture));

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("paiement");
        stage.setScene(scene);
         stage.show();
                
        }}

    @FXML
    public void valider3(ActionEvent actionEvent) throws SQLException, IOException {
         if (annuelle.isSelected()==true)
        {           
            Double ancien=   packliste.get(2).getPrix_pack();
            Double newval= (ancien-ancien*0.2);
                int id_pack = packliste.get(2).getId_pack();
        Facture f = new Facture(newval, false); 
        ServiceEnfant ser = new ServiceEnfant();
                
        personne p = Session.GetSession();

        int id_user=  ser.readIDUSer(p.getUsername());
        int facture= fs.ajouterfacture(f,id_pack,Integer.parseInt(idE.getText()),id_user) ;
        List<Integer> l= ps.get_frais(id_pack);
         for (int frais :l){
                fs.ajouterfrais_facture(l.get(l.indexOf(frais)),facture);
            }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setContentText("inscription finalisé");
        alert.showAndWait();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("kids/project/GUI/Mes_reglement.fxml"));    
       
        Parent root = (Parent)fxmlLoader.load(); 
        Mes_reglementController controller = fxmlLoader.<Mes_reglementController>getController();
        controller.setIdfacture(String.valueOf(facture));
                     System.out.println(String.valueOf(facture));

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("paiement");
        stage.setScene(scene);
         stage.show();
                   
                    
                }
            else{
                
                Double ancien=   packliste.get(2).getPrix_pack();
                int id_pack = packliste.get(2).getId_pack();
        Facture f = new Facture(ancien, false); 
        ServiceEnfant ser = new ServiceEnfant();
                
        personne p = Session.GetSession();

        int id_user=  ser.readIDUSer(p.getUsername());
        int facture= fs.ajouterfacture(f,id_pack,Integer.parseInt(idE.getText()),id_user) ;
        List<Integer> l= ps.get_frais(id_pack);
         for (int frais :l){
                fs.ajouterfrais_facture(l.get(l.indexOf(frais)),facture);
            }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setContentText("inscription finalisé");
        alert.showAndWait();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("kids/project/GUI/Mes_reglement.fxml"));    
       
        Parent root = (Parent)fxmlLoader.load(); 
        Mes_reglementController controller = fxmlLoader.<Mes_reglementController>getController();
        controller.setIdfacture(String.valueOf(facture));
                     System.out.println(String.valueOf(facture));

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("paiement");
        stage.setScene(scene);
         stage.show();
                
        }
    }

    @FXML
    public void annuel(ActionEvent actionEvent) throws SQLException {
        if (annuelle.isSelected()==true)
        {
            List<Label> list = new ArrayList<>();
                list.add(prix1);
                list.add(prix2);
                list.add(prix3);
                for (int i =0 ; i<list.size();i++){
                    double ancien=   Double.valueOf(list.get(i).getText());
                    String newval= String.valueOf(ancien-ancien*0.2);
                    list.get(i).setText(newval);
                }
            annuelle.setDisable((true));
            mensuelle.setDisable((false));
        }

        }


    @FXML
    public void mensuel(ActionEvent actionEvent) {
        if (mensuelle.isSelected()==true)
        {
            List<Label> list = new ArrayList<>();
            list.add(prix1);
            list.add(prix2);
            list.add(prix3);
            for (int i =0 ; i<list.size();i++){
                String newval =String.valueOf(packliste.get(i).getPrix_pack());
                list.get(i).setText(newval);
            }
            mensuelle.setDisable((true));
            annuelle.setDisable(false);

        }

    }





    @FXML
    public void acceuil(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
        Parent root = loader.load();
        text.getScene().setRoot(root);
    }

    @FXML
    public void enfant(ActionEvent actionEvent) {
    }

    @FXML
    public void emploi(ActionEvent actionEvent) {
    }

    @FXML
    public void event(ActionEvent actionEvent) {
    }

    @FXML
    public void payer(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("reglement.fxml"));
        Parent root = loader.load();
        text.getScene().setRoot(root);
    }

    @FXML
    public void reclamer(ActionEvent actionEvent) {
    }

    @FXML
    public void notif(ActionEvent actionEvent) {
    }

    @FXML
    public void admin(ActionEvent actionEvent) {
    }

    @FXML
    public void user(MouseEvent mouseEvent) {
    }

    @FXML
    private void buttonadd(ActionEvent event) throws SQLException, IOException {
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
            add_pane.setVisible(false);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("un nouveau pack a été ajouté avec succès");
            alert.showAndWait();
        }
         if (annuelle.isSelected()==true)
        {           
            Double ancien=   prix;
            Double newval= (ancien-ancien*0.2);
                int id_pack = ps.get_lastpack();
        Facture fact = new Facture(newval, false); 
        ServiceEnfant ser = new ServiceEnfant();
                
        personne p = Session.GetSession();

        int id_user=  ser.readIDUSer(p.getUsername());
        int facture= fs.ajouterfacture(fact,id_pack,Integer.parseInt(idE.getText()),id_user) ;
        List<Integer> lista= ps.get_frais(id_pack);
         for (int frais :l){
                fs.ajouterfrais_facture(l.get(l.indexOf(frais)),facture);
            }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setContentText("inscription finalisé");
        alert.showAndWait();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("kids/project/GUI/Mes_reglement.fxml"));    
       
        Parent root = (Parent)fxmlLoader.load(); 
        Mes_reglementController controller = fxmlLoader.<Mes_reglementController>getController();
        controller.setIdfacture(String.valueOf(facture));
                     System.out.println(String.valueOf(facture));

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("paiement");
        stage.setScene(scene);
         stage.show();
                   
                    
                }
            else{
                
                Double ancien=   prix;
                int id_pack = ps.get_lastpack();
        Facture fact = new Facture(ancien, false); 
        ServiceEnfant ser = new ServiceEnfant();
                
        personne p = Session.GetSession();

        int id_user=  ser.readIDUSer(p.getUsername());
        int facture= fs.ajouterfacture(fact,id_pack,Integer.parseInt(idE.getText()),id_user) ;
        List<Integer> lista= ps.get_frais(id_pack);
         for (int frais :l){
                fs.ajouterfrais_facture(l.get(l.indexOf(frais)),facture);
            }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setContentText("inscription finalisé");
        alert.showAndWait();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("kids/project/GUI/Mes_reglement.fxml"));    
       
        Parent root = (Parent)fxmlLoader.load(); 
        Mes_reglementController controller = fxmlLoader.<Mes_reglementController>getController();
        controller.setIdfacture(String.valueOf(facture));
                     System.out.println(String.valueOf(facture));

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("paiement");
        stage.setScene(scene);
         stage.show();
                
        }
    }

    @FXML
    private void showAddPane(ActionEvent event) {
        add_pane.setVisible(true);
    }


}
