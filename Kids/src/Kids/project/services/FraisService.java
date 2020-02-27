/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.services;

import kids.project.entities.Frais;
import kids.project.utiles.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Youssef Mimouni
 */
public class FraisService {
    private Connection con;
    private Statement ste;
    
    
    public FraisService() {
        con = DataBase.getInstance().getConnection();
    }
    
    public void ajouterfrais(Frais f) throws SQLException
    {
    PreparedStatement pre=con.prepareStatement("INSERT INTO `kidzy`.`Frais` (`id_frais`,`titre`,`prix`) VALUES (NULL,?,?);");
    pre.setString(1, f.getTitre()); 
    pre.setDouble(2, f.getPrix());
    pre.executeUpdate();
    }
    public void deletefrais(Frais f) throws SQLException {
        PreparedStatement pstmt = con.prepareStatement("DELETE FROM `frais` WHERE `frais`.`id_frais` = ?;");
        pstmt.setInt(1,f.getId_frais());
        pstmt.executeUpdate();
        
    }
    
    
    public List<Frais> readAllfrais() throws SQLException {
    List<Frais> listefrais=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from frais");
     while (rs.next()) {  
               int id = rs.getInt("id_frais");
               String type=rs.getString("titre");
               Double prix=rs.getDouble("prix");
               Frais f=new Frais(type,prix);
                f.setId_frais(id);
     listefrais.add(f);
     }
    return listefrais;
    }
    
    public Frais getFrais(int id ) throws SQLException {
            ste=con.createStatement();
            ResultSet rs=ste.executeQuery("select * from frais where id_frais = '" + id + "'");
            while(rs.next()) {
                int id_frais = rs.getInt("id_frais");
                String titre = rs.getString("titre");
                Double prix = rs.getDouble("prix");
                Frais f = new Frais(id_frais,titre, prix);
                return f;
            }
        return null;
        
    }

}
