/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.services;

import kids.project.entities.Facture;
import kids.project.utiles.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kids.project.entities.enfantClasse;

/**
 *
 * @author Youssef Mimouni
 */
public class FactureService {

    private Connection con;
    private Statement ste;

    public FactureService() {
        con = DataBase.getInstance().getConnection();
    }
    
    public int ajouterfacture(Facture f,int id_pack, int id_enfant,int id_parent) throws SQLException {
        
        ste = con.createStatement();
        String pre = "INSERT INTO `facture` (`id_facture`,`total`, `date_facture`,`id_enf`,`id_parent`,`paye`,`id_pack`) VALUES (null,'"+ f.getTotal()+"','"+ f.getDate_facture()+"','"+id_enfant+"','"+id_parent+"',0,'"+id_pack+"');";
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

    public void deletefacture(Facture f) throws SQLException {
        PreparedStatement pstmt = con.prepareStatement("DELETE FROM `facture` WHERE `facture`.`id` = ?;");
        pstmt.setInt(1, f.getId_fact());
        pstmt.executeUpdate();

    }

    public List<Facture> readAllFacture() throws SQLException {
        List<Facture> listefature = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from facture");
        while (rs.next()) {
            int id = rs.getInt("id_fact");
            Double total = rs.getDouble("total");
            Boolean paye = rs.getBoolean("paye");
            int id_pack = rs.getInt("id_pack");
            Facture f = new Facture(total, paye);
            f.setId_fact(id);
            listefature.add(f);
        }
        return listefature;
    }
     public String afficher(Facture v, int idF) {
        String msg = "";
        try {
            Statement st2 = con.createStatement();
            String requete = "select id_enfant, id_facture,id_parent,nom_enfant,prenom_enfant,total,paye,id_pack from enfant , facture WHERE enfant.id_enfant=facture.id_enf and id_facture ='"+idF+"'";
            ResultSet rs = st2.executeQuery(requete);
            while (rs.next()) {
                //System.out.println(rs.toString());
                msg = "\r\n Nom enfant: " + " :  " + rs.getString(4)
                        + "\r\n" + "Prenom enfant :  " + rs.getString(5)
                        + "\r\n" + "Total :  " + rs.getString(6)
                        + "\r\n" + "Status facture :  " + rs.getString(7);
            }
        } catch (SQLException ex) {
            System.out.println("Pas de pdf" + ex.getMessage());
        }
        return msg;
    }
    public Map Facture_enfant(int idF) throws SQLException {
        HashMap<String,Object> enfant_facture = new HashMap<String, Object>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select id_enfant, id_facture,id_parent,nom_enfant,prenom_enfant,total,paye,id_pack from enfant , facture WHERE enfant.id_enfant=facture.id_enf and id_facture ='"+idF+"'");
        while (rs.next()) {
            int id = rs.getInt("id_enfant");
            int id_facture =rs.getInt("id_facture");
            int id_parent =rs.getInt("id_parent");
            String nom_enfant=rs.getString("nom_enfant");
            String prenom_enfant=rs.getString("prenom_enfant");

            Double total = rs.getDouble("total");
            Boolean paye = rs.getBoolean("paye");
            int id_pack = rs.getInt("id_pack");
            Facture f = new Facture(total, paye);
            
            f.setId_fact(id);
            enfant_facture.put("facture", f);
            enfantClasse e = new enfantClasse();
            e.setNom_enfant(nom_enfant);
            e.setPrenom_enfant(prenom_enfant);
            enfant_facture.put("enfant", e);
          
        }
        return enfant_facture;
    }

    public void ajouterfrais_facture(int id_frais, int id_facture) throws SQLException {
        PreparedStatement pre = con.prepareStatement("INSERT INTO `frais_facture` (`id`, `id_facture`, `id_frais`) VALUES (NULL,?,?);");
        pre.setInt(1, id_facture);
        pre.setInt(2, id_frais);
        pre.executeUpdate();
    }
}
