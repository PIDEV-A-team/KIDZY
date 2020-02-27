/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import kids.project.utiles.DataBase;

/**
 *
 * @author ferjani
 */
public class ServiceClasse {
    
    
     private Connection con;
    private Statement ste;

    public ServiceClasse() {
        con = DataBase.getInstance().getConnection();
    }
    
     public ObservableList<String> readAllClasses() throws SQLException {

        ObservableList<String> arr = FXCollections.observableArrayList();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select DISTINCT (libelle_cla) from classe");
        while (rs.next()) {

            String classe = rs.getString("libelle_cla");
            arr.add(classe);
        }
        return arr;
    }
    
}
