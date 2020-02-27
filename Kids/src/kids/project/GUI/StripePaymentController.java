/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.GUI;

import kids.project.entities.personne;
import kids.project.services.services_personne;
import kids.project.utiles.StripeSession;
import kids.project.services.Session;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javax.security.auth.kerberos.ServicePermission;

/**
 * FXML Controller class
 *
 * @author Oussama Fezzani
 */
public class StripePaymentController implements Initializable {
      public TextField idS= new TextField();
      public TextField idenfant = new TextField();



    @FXML
    private VBox vbox1;
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

    /**
     * Initializes the controller class.
     */
    public void setIdfactureSTRIPE(String idS)
    {       
    this.idS.setText(idS);  
    }  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Platform.runLater(() -> {

        //do stuff
});   
//
//        /* int enf = Integer.parseInt(idE.getText());
//        System.out.println(enf);*/
//        services_personne user = new services_personne();
//      //  System.out.println(Session.GetSession().getId());
//        int total = user.checkPaid(59,100,20);
//        WebView webv = new WebView();
//        WebEngine webe = webv.getEngine();
//        System.out.println("hello");
//        webe.load("http://localhost/stripe/charge.html");
//        vbox1.getChildren().addAll(webv);
//        System.out.println("hello2222");
//        webe.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
//            @Override
//            public void changed(ObservableValue ov, Worker.State oldState, Worker.State newState) {
//
//                if (newState == Worker.State.SUCCEEDED) {
//                    if (webe.getLocation().contains("success.php")) {
//                        try {
//                            StripeSession.getInstance(webe.getLocation());
//                            System.out.println(StripeSession.getInstance().getUrl());
//                            String token = StripeSession.getInstance().getUrl();
//                            String token1 = StripeSession.getInstance().getUrl();
//                            
//                            int index1 = token.lastIndexOf("&");
//                            String lastemail = token.substring(index1 + 13);
//                            String StripeEmail = lastemail.replace("%40", "@");
//                            System.out.println("Email : " + StripeEmail);
//                            String lastat = token1.replaceAll(".*?stripeToken=(.*)&.*", "$1");
//                            int index = lastat.indexOf("&");
//                            String StripeToken = lastat.substring(0, index);
//                            System.out.println("Token : " + StripeToken);
//                            
//                            Stripe.apiKey = "sk_test_8ALE8KvualtaiYISubY6JCxs";
//                            
//                            
//                            Map<String, Object> chargeMap = new HashMap<String, Object>();
//                            chargeMap.put("amount", total * 100);
//                            chargeMap.put("currency", "usd");
//                            chargeMap.put("source", StripeToken);
//                            
//                            Map<String, Object> CustomerMap = new HashMap<String, Object>();
//                            CustomerMap.put("email", StripeEmail);
//                            
//                            try {
//                                Charge charge = Charge.create(chargeMap);
//                                Customer customer = Customer.create(CustomerMap);
//                                //System.out.println(charge);
//                            } catch (StripeException e) {
//                                e.printStackTrace();
//                            }
//                            user.updatePaiement(Session.GetSession().getId());
//                            Parent root = FXMLLoader.load(getClass().getResource("home_parent.fxml"));
//                            Scene scene = new Scene(root);
//                            Stage stage = new Stage();
//                            stage.setTitle("Kidzy");
//                            stage.setScene(scene);
//                            stage.show();
//                            vbox1.getScene().getWindow().hide();
//                        } catch (IOException ex) {
//                            Logger.getLogger(StripePaymentController.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    }
//
//                }
//
//            }
//
//        });
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
    private void payer(ActionEvent event) {
    }

    @FXML
    private void reclamer(ActionEvent event) {
    }

    @FXML
    private void notif(ActionEvent event) {
    }

    @FXML
    private void admin(ActionEvent event) {
    }

    @FXML
    private void user(MouseEvent event) {
    }
    @FXML
    private void payerstripe(ActionEvent event){
        int facture = Integer.parseInt(idS.getText());
        
        System.out.println(facture);
        services_personne user = new services_personne();
        System.out.println(Session.GetSession().getId());
        int total = user.checkPaid(facture);
        WebView webv = new WebView();
        WebEngine webe = webv.getEngine();
        System.out.println("hello");
        webe.load("http://localhost/stripe/charge.html");
        vbox1.getChildren().addAll(webv);
        System.out.println("hello2222");
        webe.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
            @Override
            public void changed(ObservableValue ov, Worker.State oldState, Worker.State newState) {

                if (newState == Worker.State.SUCCEEDED) {
                    if (webe.getLocation().contains("success.php")) {
                        try {
                            StripeSession.getInstance(webe.getLocation());
                            System.out.println(StripeSession.getInstance().getUrl());
                            String token = StripeSession.getInstance().getUrl();
                            String token1 = StripeSession.getInstance().getUrl();
                            
                            int index1 = token.lastIndexOf("&");
                            String lastemail = token.substring(index1 + 13);
                            String StripeEmail = lastemail.replace("%40", "@");
                            System.out.println("Email : " + StripeEmail);
                            String lastat = token1.replaceAll(".*?stripeToken=(.*)&.*", "$1");
                            int index = lastat.indexOf("&");
                            String StripeToken = lastat.substring(0, index);
                            System.out.println("Token : " + StripeToken);
                            
                            Stripe.apiKey = "sk_test_8ALE8KvualtaiYISubY6JCxs";
                            
                            
                            Map<String, Object> chargeMap = new HashMap<String, Object>();
                            chargeMap.put("amount", total * 100);
                            chargeMap.put("currency", "usd");
                            chargeMap.put("source", StripeToken);
                            
                            Map<String, Object> CustomerMap = new HashMap<String, Object>();
                            CustomerMap.put("email", StripeEmail);
                            
                            try {
                                Charge charge = Charge.create(chargeMap);
                                Customer customer = Customer.create(CustomerMap);
                                //System.out.println(charge);
                            } catch (StripeException e) {
                                e.printStackTrace();
                            }
                            user.updatePaiement(Session.GetSession().getId());
                            Parent root = FXMLLoader.load(getClass().getResource("home_parent.fxml"));
                            Scene scene = new Scene(root);
                            Stage stage = new Stage();
                            stage.setTitle("Kidzy");
                            stage.setScene(scene);
                            stage.show();
                            vbox1.getScene().getWindow().hide();
                        } catch (IOException ex) {
                            Logger.getLogger(StripePaymentController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }

            }

        });
    }

}
