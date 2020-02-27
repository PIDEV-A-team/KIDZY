/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.GUI;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ferjani
 */
public class Rim extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
         try {
            Parent root = FXMLLoader
                    .load(getClass().getResource("home_parent.fxml"));

            Scene scene = new Scene(root);

            primaryStage.setTitle("dashboard");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


    }
    
    
     public static void main(String[] args) {
        launch(args);
    }
    
}
