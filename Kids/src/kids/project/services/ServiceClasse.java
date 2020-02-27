/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import kids.project.entities.enfantClasse;
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
        ResultSet rs = ste.executeQuery("Select DISTINCT (libelle_cla) from classe");
        while (rs.next()) {

            String classe = rs.getString("libelle_cla");
            arr.add(classe);
        }
        return arr;
    }

    public ObservableList<String> readClasses(String username) throws SQLException {

        ObservableList<String> arra = FXCollections.observableArrayList();
        PreparedStatement pt = con.prepareStatement("Select DISTINCT (libelle_cla) from classe c, seance s,user u WHERE u.id=s.id and  s.id_classe = c.id_classe and u.username=? ");
        pt.setString(1, username);
        ResultSet rs = pt.executeQuery();

        while (rs.next()) {

            String classe = rs.getString("libelle_cla");
            arra.add(classe);
        }
        return arra;
    }

    public int readIdClasse(String libelle_cla) throws SQLException {
        int id = 0;
        ste = con.createStatement();
        String query = "Select id_classe from classe where libelle_cla = ?";
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1, libelle_cla);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            id = rs.getInt("id_classe");
        }

        return id;
    }

    public ObservableList<enfantClasse> afficher_enfant(int id) throws SQLException {

        ObservableList<enfantClasse> list = FXCollections.observableArrayList();
        ste = con.createStatement();
        String query = "SELECT nom_enfant , prenom_enfant from enfant  where  id_classe = ?";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
       while (rs.next()) {
            enfantClasse enf = new enfantClasse();

            enf.setId_enfant(rs.getInt(1));
            enf.setNom_enfant(rs.getString("nom_enfant"));
            enf.setPrenom_enfant(rs.getString("prenom_enfant"));
            enf.setId_classe(rs.getInt("id_classe"));

            list.add(enf);

        }
        return list;
    }
}
