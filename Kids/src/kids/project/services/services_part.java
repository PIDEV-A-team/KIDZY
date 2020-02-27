/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import kids.project.entities.event;
import kids.project.entities.participation;
import kids.project.utils.DataBase;

/**
 *
 * @author ASUS
 */
public class services_part {
     private Connection con;
    private Statement ste;
    
    public services_part() {
        con = DataBase.getInstance().getConnection(); 
    }
     public void ajouter(participation p) throws SQLException
    {
    PreparedStatement pre=con.prepareStatement("INSERT INTO `kidzy`.`participation` (`id_enfant`, `id_event`, `date_partici` ) VALUES ( ?, ?, ?);");
    pre.setInt(1,2);
    pre.setInt(2, 1);
    pre.setString(3,"01 janvier 2020" );
   
    pre.executeUpdate();
    }
     
    
     
      

    public void modifier(participation p1, int i, int i0, String _mars_2020, String wouuuuuuh) throws SQLException {
       PreparedStatement pre = con.prepareStatement("UPDATE participation set date_partici = ? , description = ? WHERE id_partici = 4 ");
  
    pre.setString(1,"01 mars 2020");
    pre.setString(2, "wouuuuh");
   
    pre.executeUpdate();
       
    }

    public void delete(int i) throws SQLException {
PreparedStatement pre = con.prepareStatement("DELETE FROM `kidzy`.`participation` WHERE `id_partici`= ?");
            pre.setInt(1, i);
            pre.execute();
    }
    
    public ObservableList<String> listepart(int id) throws SQLException {
           ObservableList<String>arr = FXCollections.observableArrayList();
        String msg = "";
        ste = con.createStatement();
        PreparedStatement pre = con.prepareStatement("SELECT nom_enfant, prenom_enfant FROM `participation` p, enfant e WHERE e.id_enfant = p.id_enfant AND id_event =?");
        pre.setInt(1, id);
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
      
        String a= rs.getString("nom_enfant");
        String p=rs.getString("prenom_enfant");
        msg = a+" "+p;
        
        arr.add(msg);
       
    }
        return arr;
}
}
