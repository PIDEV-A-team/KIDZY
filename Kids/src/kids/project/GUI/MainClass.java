/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.GUI;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import kids.project.services.FraisService;
import kids.project.services.packservice;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import kids.project.entities.Facture;
import kids.project.entities.enfantClasse;
import kids.project.entities.pack;
import kids.project.services.ServiceEnfant;

/**
 *
 * @author Youssef Mimouni
 */
public class MainClass extends Application {

    @Override
    public void start(Stage primaryStage) throws SQLException {
        try {
            Parent root = FXMLLoader
                    .load(getClass().getResource("FXMLLogin.fxml"));

            Scene scene = new Scene(root);

            primaryStage.setTitle("KIDZY");
            primaryStage.setScene(scene); 
            primaryStage.show();
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) throws SQLException {
        launch(args);
        

/*      try {
            packservice pser = new packservice();
            FraisService ser = new FraisService();
            int[] frais = new int[]{1,2};
            double total = 500;
            for (int i=0;i<frais.length ;i++) {
                total = total + ser.getFrais(frais[i]).getPrix() ;
            }

            pack f = new pack("pack8",total , "all in one");


            int pack = pser.ajouterpack(f);
            if (pack!=0) {
                for (int i=0;i<frais.length ;i++){
                    pser.ajouterfrais_pack(frais[i], pack);
                }
            }

        }
        catch (SQLException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        /*try {
            FactureService fser = new FactureService();
            FraisService ser = new FraisService();
            int[] frais = new int[]{1};
            double total = 500;
            for (int i=0;i<frais.length ;i++) {
                total = total + ser.getFrais(frais[i]).getPrix() ;
            }

            Facture f = new Facture(total , false);


            int facture = fser.ajouterfacture(f);
            if (facture!=0) {
                for (int i=0;i<frais.length ;i++){
                    fser.ajouterfrais_facture(frais[i], facture);
                }
            }

        }
        catch (SQLException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }*/

    }
}
