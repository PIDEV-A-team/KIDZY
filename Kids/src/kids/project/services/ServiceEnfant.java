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
import kids.project.IServices.IServicesEnfant;
import kids.project.entities.enfant;
import kids.project.entities.enfantClasse;
import kids.project.utiles.DataBase;

/**
 *
 * @author ferjani
 */
public class ServiceEnfant implements IServicesEnfant<enfant> {

    private final Connection con;
    private Statement ste;

    public ServiceEnfant() {
        con = DataBase.getInstance().getConnection();
    }

 
    public void ajouterEnfant(enfantClasse e) throws SQLException {
        
        
        PreparedStatement p = con.prepareStatement("INSERT INTO `enfant`( `id`, `id_classe`,`nom_enfant`, `prenom_enfant`,`image_enfant`,`dateN_enfant`) VALUES (?,?,?,?,?,?);");

        p.setInt(1,e.getId());
        p.setInt(2, e.getId_classe());
        p.setString(3, e.getNom_enfant());
        p.setString(4, e.getPrenom_enfant());
         p.setString(5, e.getImage_enfant());
        p.setString(6, e.getDateN_enfant());
        p.executeUpdate();
        System.out.println("enfant ajouté");
    }
    public int ajouterenfant2(enfantClasse e) throws SQLException {
        
        String pre = "INSERT INTO `enfant`( `id_enfant`,`id`, `id_classe`,`nom_enfant`, `prenom_enfant`,`image_enfant`,`dateN_enfant`) VALUES (null,'"+ e.getId()+"','"+e.getId_classe()+"','"+e.getNom_enfant()+"','"+e.getPrenom_enfant()+"','"+e.getImage_enfant()+"','"+e.getDateN_enfant()+"');";
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

    public Integer insertQueryGetId(enfantClasse e) {
    Integer numero=0;
    Integer lastinserted=-1;
    try {
        Statement stmt = con.createStatement();
        String query = "INSERT INTO `enfant`( `id_enfant`,`id`, `id_classe`,`nom_enfant`, `prenom_enfant`,`image_enfant`,`dateN_enfant`) VALUES (null,'"+ e.getId()+"','"+e.getId_classe()+"','"+e.getNom_enfant()+"','"+e.getPrenom_enfant()+"','"+e.getImage_enfant()+"','"+e.getDateN_enfant()+"');";

        numero = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()){
            lastinserted=rs.getInt(1);
        }
        rs.close();

        stmt.close();
    } catch (Exception m) {
        m.printStackTrace();
        lastinserted=-1;
    }
  return lastinserted;
}



@Override
     public boolean modifierEnfant( enfantClasse e1 ,String nom, String prenom, String date ,String libelle_cla ) throws SQLException {
        PreparedStatement ps = con.prepareStatement("UPDATE enfant e SET e.nom_enfant=? ,"
                + " e.prenom_enfant=? , e.dateN_enfant=? ,e.id_classe=(select id_classe from classe "
                + "where libelle_cla = ? ) Where id_enfant=? ;");
        
        ps.setString(1, nom);
        ps.setString(2, prenom);
        ps.setString(3, date);
        ps.setString(4,libelle_cla );
        ps.setInt(5,e1.getId_enfant() );
       
        ps.execute();
        return true;

    }

    public void deleteE(enfantClasse e) throws SQLException {
        String query = "DELETE FROM `enfant` WHERE `id_enfant` = '" + e.getId_enfant() + "';";
        PreparedStatement st = con.prepareStatement(query);
        st.execute();
    }
    
    @Override
     public void afficher_Enfant() throws SQLException {

        Statement st = con.createStatement();
        String raq = "select * from enfant ";
        ResultSet res = st.executeQuery(raq);
        while (res.next()) {
            System.out.println(
                    "\n :" + res.getInt(2)
                    + "\n  :" + res.getInt(3)
                    + "\n nom :" + res.getString(4)
                    + "\n prenom :" + res.getString(5)
                    + "\n image :" + res.getString(6)
                    + "\n date de naissance :" + res.getDate(7)              
            );
        }

    }
 public int readIDUSer(String username) throws SQLException{
        int id = 0 ;
        ste = con.createStatement();
         String query ="Select id from user where username = ?";
         PreparedStatement st = con.prepareStatement(query);
         st.setString(1, username);
        ResultSet rs = st.executeQuery();
            while (rs.next()) {
            id= rs.getInt("id");
            }
         
   return id;
 }
    @Override
    public ObservableList<enfantClasse> readAll() throws SQLException {
       
        ObservableList<enfantClasse> oblistEnfant = FXCollections.observableArrayList();
        ste = con.createStatement();
        ResultSet result = ste.executeQuery("Select e.id_enfant, e.id_classe , e.nom_enfant,e.prenom_enfant,c.libelle_cla, e.dateN_enfant from enfant e INNER JOIN classe c on (c.id_classe =e.id_classe) ");

        while (result.next()) {
            enfantClasse enf = new enfantClasse();
         
                       enf.setId_enfant(result.getInt(1));
                       enf.setNom_enfant(result.getString("nom_enfant"));
                       enf.setPrenom_enfant(result.getString("prenom_enfant"));
                       enf.setLibelle_cla(result.getString("libelle_cla"));
                       enf.setDateN_enfant(result.getString("dateN_enfant"));
                       enf.setId_classe(result.getInt("id_classe"));
           
           
                       oblistEnfant.add(enf);

        }
        return oblistEnfant;

    }

    @Override
    public void delete(enfant e) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

   public int readClasse(String libelle_cla) throws SQLException{
        int id = 0 ;
        ste = con.createStatement();
         String query ="Select id_classe from classe where libelle_cla = ?";
         PreparedStatement st = con.prepareStatement(query);
         st.setString(1, libelle_cla);
        ResultSet rs = st.executeQuery();
            while (rs.next()) {
            id= rs.getInt("id_classe");
            }
         
   return id;
 }
   
   
      public void nbEnfant() throws SQLException {
        ste = con.createStatement();
        String req = "  select count(*) from enfant";
        ResultSet result = ste.executeQuery(req);
        int count = 0;
        while (result.next()) {
            count = result.getInt(1);

        }
        System.out.println("nombre enfant est :" + count);
    }

}


