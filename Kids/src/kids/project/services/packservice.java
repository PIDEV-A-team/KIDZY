package kids.project.services;

import kids.project.entities.Facture;
import kids.project.entities.pack;
import kids.project.utiles.DataBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class packservice {
    private Connection con;
    private Statement ste;

    public packservice() {
        con = DataBase.getInstance().getConnection();
    }
    public int ajouterpack(pack p) throws SQLException {

        ste = con.createStatement();
        String pre = "INSERT INTO `pack` (`id_pack`,`nom_pack`, `prix_pack`,`description_pack`) VALUES (null,'"+ p.getNom_pack()+"','"+ p.getPrix_pack()+"','"+ p.getDescription_pack()+"')";
        /*pre.setDouble(1, f.getTotal());
        pre.setDate(2, f.getDate_facture());
        pre.setInt(3, 1);
        pre.setInt(4, 1);
        pre.setBoolean(5, f.getpaye());*/
        long lastInsertedID = ste.executeUpdate(pre, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = ste.getGeneratedKeys();
        while (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }
    public void deletepack(int id) throws SQLException {
        PreparedStatement pstmt = con.prepareStatement("DELETE FROM `pack` WHERE `pack`.`id_pack` = '"+id+"';");

        pstmt.executeUpdate();
    }
    public void updatepack(pack p) throws SQLException{
        String sql = "UPDATE `pack` SET `nom_pack` = ?, `prix_pack` = ?, `description_pack` = ? WHERE `pack`.`id_pack` = ?";

        PreparedStatement statement = con.prepareStatement(sql);
    statement.setString(1, p.getNom_pack());
    statement.setDouble(2, p.getPrix_pack());
    statement.setString(3, p.getDescription_pack());
        statement.setInt(4,p.getId_pack());

        int rowsUpdated = statement.executeUpdate();
if (rowsUpdated > 0) {
        System.out.println("An existing user was updated successfully!");
    }
    }
    public void updatedescription(pack p) throws SQLException{
        String sql = "UPDATE `pack` SET `description_pack` = ? WHERE `pack`.`id_pack` = ?";

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, p.getDescription_pack());
        statement.setInt(2,p.getId_pack());

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing user was updated successfully!");
        }
    }
    public void updatenom(pack p) throws SQLException{
        String sql = "UPDATE `pack` SET `nom_pack` = ? WHERE `pack`.`id_pack` = ?";

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, p.getNom_pack());
        statement.setInt(2,p.getId_pack());

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing user was updated successfully!");
        }
    }
    public void updateprix(pack p) throws SQLException{
        String sql = "UPDATE `pack` SET  `prix_pack` = ? WHERE `pack`.`id_pack` = ?";

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setDouble(1, p.getPrix_pack());
        statement.setInt(2,p.getId_pack());

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing user was updated successfully!");
        }
    }
    public ObservableList<pack> readAllpack() throws SQLException {
        ObservableList<pack> listepack= FXCollections.observableArrayList();
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select * from pack");
        while (rs.next()) {
            int id = rs.getInt("id_pack");
            String nom=rs.getString("nom_pack");
            Double prix=rs.getDouble("prix_pack");
            String description= rs.getString("description_pack");
            pack p=new pack(nom,prix,description);

            p.setId_pack(id);
            listepack.add(p);
        }
        return listepack;
    }
    /* ObservableList<pack> readAllpack2() throws SQLException {
        ObservableList<pack> listepack= FXCollections.observableArrayList();
        ObservableList<Checkbox> listefrais= FXCollections.observableArrayList();

        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select * from pack");
        while (rs.next()) {
            int id = rs.getInt("id_pack");
            String nom=rs.getString("nom_pack");
            Double prix=rs.getDouble("prix_pack");
            String description= rs.getString("description_pack");
            listefrais=this.get_frais_pack(id);
            pack p=new pack(nom,prix,description);
            p.setListefrais(listefrais);
            p.setId_pack(id);
            listepack.add(p);
        }
        return listepack;
    }*/
    public ObservableList<Integer> get_frais_pack(int id) throws SQLException {
        ObservableList<Integer> listefrais= FXCollections.observableArrayList();
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select id_frais from pack,pack_frais where pack_frais.id_pack='"+id+"'");
        while (rs.next()) {

                int id_frais = rs.getInt("id_frais");
                listefrais.add(id_frais);

        }
        return listefrais;
    }
    public ObservableList<Integer> get_frais(int id) throws SQLException {
        ObservableList<Integer> listefrais= FXCollections.observableArrayList();
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select id_frais from pack_frais where pack_frais.id_pack='"+id+"'");
        while (rs.next()) {

            int id_frais = rs.getInt("id_frais");
            listefrais.add(id_frais);

        }
        return listefrais;
    }
    public int get_lastpack() throws SQLException {
        ste=con.createStatement();
        int id_pack =0;
        ResultSet rs=ste.executeQuery("select id_pack from facture ORDER BY id_facture DESC LIMIT 1;");
        while (rs.next()) {

             id_pack = rs.getInt("id_pack");

        }
        return id_pack;
    }

    public void ajouterfrais_pack(int id_frais, int id_pack) throws SQLException {
        PreparedStatement pre = con.prepareStatement("INSERT INTO `pack_frais` (`id`, `id_pack`, `id_frais`) VALUES (NULL,?,?);");
        pre.setInt(1, id_pack);
        pre.setInt(2, id_frais);
        pre.executeUpdate();
    }

    public void deletePack_Frais(int id_frais, int id_pack) throws SQLException {
        PreparedStatement pstmt = con.prepareStatement("DELETE FROM `pack_frais` WHERE `pack_frais`.`id_pack` = '"+id_pack+"' and `pack_frais`.`id_frais` = '"+id_frais+"';");
       // pstmt.setInt(1, f.getId_fact());
        pstmt.executeUpdate();

    }

}
