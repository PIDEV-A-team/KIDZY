/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import kids.project.services.ServiceParticipation;

/**
 * FXML Controller class
 *
 * @author ferjani
 */
public class ChartAdminController implements Initializable {

    @FXML
    private PieChart chartEnfant;
    @FXML
    private Button btn_detail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        chart();
    }

    public ObservableList<PieChart.Data> chart() {
        ServiceParticipation p = new ServiceParticipation();
        ObservableList<PieChart.Data> pieChartData
                = FXCollections.observableArrayList(
                        new PieChart.Data("Participer", p.getEnfantP(3)),
                        new PieChart.Data("Non participer", p.getEnfantNonP(3)));

        chartEnfant.setData(pieChartData);
        return pieChartData;
    }

    @FXML
    private void Affiche_details(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader
                .load(getClass().getResource("ListeEnfantEvent.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Liste des participants");
        stage.setScene(scene);
        stage.show();
    }

}
