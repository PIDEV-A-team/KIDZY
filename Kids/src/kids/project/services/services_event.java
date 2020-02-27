
package kids.project.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import kids.project.entities.enfant;
import kids.project.entities.event;
import kids.project.utils.DataBase;




/**
 *
 * @author ASUS
 */
    
   public class services_event {

    private final Connection con;
    private Statement ste;

    public services_event() {
        con = DataBase.getInstance().getConnection(); 
}
    public void ajouter(event e) throws SQLException
    {
    PreparedStatement pre=con.prepareStatement("INSERT INTO `kidzy`.`event` (`nom_event`, `date_event`, `prix_event`, `descr_event`, `type_event`, `lieu_event` ) VALUES ( ?, ?, ?, ?, ?, ?);");
    pre.setString(1, e.getNom_event());
    pre.setString(2, e.getDate_event());
    pre.setDouble(3, e.getPrix_event());
    pre.setString(4, e.getDesc_event());
    pre.setString(5, e.getType_event());
    pre.setString(6, e.getLieu_event());
    pre.executeUpdate();
    }
    public void deleteEvent(event e) throws SQLException {
        
            PreparedStatement pre = con.prepareStatement("DELETE FROM `kidzy`.`event` WHERE `nom_event`= ?  ");
            pre.setString(1, e.getNom_event());
            pre.execute();
        
    }
    public boolean modifierEvent(event e ,String nom_event, String date_event, double prix_event, String descr_event, String type_event, String lieu_event) throws SQLException {

        PreparedStatement pt = con.prepareStatement("UPDATE event SET nom_event=?,date_event=?,prix_event=?,descr_event=?,type_event=?,lieu_event=? WHERE nom_event=?");
        pt.setString(1,nom_event);
        pt.setString(2,date_event);
        pt.setDouble(3, prix_event);
        pt.setString(4, descr_event);
        pt.setString(5, type_event);
        pt.setString(6, lieu_event);
        pt.setString(7,e.getNom_event());
        pt.execute();
        return true;
    }

     
     public ObservableList<event> afficherevent() throws SQLException {
            ObservableList<event> arr=FXCollections.observableArrayList();
            PreparedStatement pre = con.prepareStatement("select * from event");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                
                // System.out.println("evenement{ id:" + rs.getInt(1) + ", nom: " + rs.getString(2) + ", date: " + rs.getDate(3) + ",  prix: " + rs.getDouble(4) + ",  contenu: " + rs.getString(5) +  ",  type: " + rs.getString(6) + ",  lieu: " + rs.getString(7) +"}");
               int id=rs.getInt(1);
               String nom=rs.getString("nom_event");
               String date =rs.getString(3);
               Double prix=rs.getDouble(4);
               String desc=rs.getString(5);
               String type=rs.getString(6);
               String lieu=rs.getString(7);
               event p=new event(id,nom,date,prix,desc,type,lieu);
     arr.add(p);
     }
    return arr;
       
    }
      public ArrayList<event> TriParNom() throws SQLException {
            ArrayList<event> arr= new ArrayList<>();
            PreparedStatement pre = con.prepareStatement("select * from event");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                
                 System.out.println("evenement{ id:" + rs.getInt(1) + ", nom: " + rs.getString(2) + ", date: " + rs.getDate(3) + ",  prix: " + rs.getDouble(4) + ",  contenu: " + rs.getString(5) +  ",  type: " + rs.getString(6) + ",  lieu: " + rs.getString(7) +"}");
              int id=rs.getInt(1);
               String nom=rs.getString("nom_event");
               String date =rs.getString(3);
               Double prix=rs.getDouble(4);
               String desc=rs.getString(5);
               String type=rs.getString(6);
               String lieu=rs.getString(7);
               event p=new event( nom,date,prix,desc,type,lieu);
     arr.add(p);
   

     
     }
              Collections.sort(arr, new event());
    return arr;
       
    }
        
         
        public event affichereventparnom(String nom_event) throws SQLException {
             event e = new event();
            ste = con.createStatement();
           PreparedStatement pre = con.prepareStatement("select * from event WHERE nom_event = ?");
            pre.setString(1, nom_event);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) { 
              e.setId_event(rs.getInt("id_event"));
            e.setNom_event(rs.getString("nom_event"));
            e.setDate_event(rs.getString(3));
            e.setPrix_event((float) rs.getDouble(4));
            e.setDesc_event(rs.getString(5));
            e.setType_event(rs.getString(6));
            e.setLieu_event(rs.getString(7));
         
           
                 

            }
      
        return e;
    }
      public event cherchereventN(String nom_event) throws SQLException {

        event e = new event();
        ste = con.createStatement();
        PreparedStatement pre = con.prepareStatement("select * from event where `nom_event`=?");
        pre.setString(1, nom_event);
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
          e.setId_event(rs.getInt("id_event"));
            e.setNom_event(rs.getString("nom_event"));
            e.setDate_event(rs.getString(3));
            e.setPrix_event((float) rs.getDouble(4));
            e.setDesc_event(rs.getString(5));
            e.setType_event(rs.getString(6));
            e.setLieu_event(rs.getString(7));
         
         
        }
        return e;
    }
     
      
       public event affievent(event e) throws SQLException {

        ste = con.createStatement();
        PreparedStatement pre = con.prepareStatement("select nom_event, date_event, prix_event, descr_event, type_event, lieu_event from event where `id_event`=?");
        pre.setInt(1, e.getId_event());
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
           // e.setId_event(rs.getInt("id_event"));
            e.setNom_event(rs.getString("nom_event"));
            e.setDate_event(rs.getString("date_event"));
            e.setPrix_event((float) rs.getDouble("prix_event"));
            e.setDesc_event(rs.getString("descr_event"));
            e.setType_event(rs.getString("type_event"));
            e.setLieu_event(rs.getString("lieu_event"));
         
        }
        return e;
    }
       
       public event cherchereventT(String type_event) throws SQLException {

        event e = new event();
        ste = con.createStatement();
        PreparedStatement pre = con.prepareStatement("select * from event where `type_event`=?");
        pre.setString(1, type_event);
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            e.setId_event(rs.getInt(1));
            e.setNom_event(rs.getString(2));
            e.setDate_event(rs.getString(3));
           e.setPrix_event((float) rs.getDouble(4));
            e.setDesc_event(rs.getString(5));
            e.setType_event(rs.getString(6));
            e.setLieu_event(rs.getString(7));
         
        }
        return e;
    }
        public ArrayList<event> chercherev(String e) throws SQLException {

        ArrayList<event> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("SELECT * FROM `event` WHERE `username` LIKE '%" + e + "%'");
        while (rs.next()) {

            
            String nom_event = rs.getString("nom_event");
            String date_event = rs.getString("date_event");
            String prix_event = rs.getString("prix_event");
            String descr_event = rs.getString("descr_event");
            String type_event = rs.getString("type_event");
            String lieu_event = rs.getString("lieu_event");
           
            event ev = new event(nom_event, date_event, prix_event, descr_event, type_event, lieu_event);

            arr.add(ev);
        }
        return arr;

    }
        public ObservableList<String> afficherenfant(String username ) throws SQLException {
            ObservableList<String>arr = FXCollections.observableArrayList();
String msg = "";
ste = con.createStatement();
        PreparedStatement pre = con.prepareStatement("SELECT e.nom_enfant FROM enfant e INNER JOIN user u ON (e.id = u.id) WHERE u.roles = \"Parent\"and u.username=?");
        pre.setString(1, username);
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
        String a= rs.getString("nom_enfant");
       
        msg = a+" ";
        
        arr.add(msg);
       
    }
        return arr;
   }
        
        public ArrayList<String> mails( ) throws SQLException{
            ArrayList<String>arr = new ArrayList<>();
            ste = con.createStatement();
        PreparedStatement pre = con.prepareStatement("SELECT u.email FROM user u WHERE u.roles = \"Parent\"");
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
        String email = rs.getString("email");
        arr.add(email);
        } 
        return arr;
        }
        public int getId(String nom ) throws SQLException{
        int x =0;
        ste = con.createStatement();
        PreparedStatement pre = con.prepareStatement("SELECT id_enfant FROM enfant  WHERE nom_enfant=?");
        pre.setString(1, nom);
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
         x= rs.getInt("id_enfant");
        }
      
        return x;
        }
         public void enregistrer(int idR ,int idE) throws SQLException
    {
    PreparedStatement pre=con.prepareStatement("INSERT INTO `participation` (`id_enfant`, `id_event`) VALUES (?, ?)");
    pre.setInt(1, idR);
    pre.setInt(2, idE);
    pre.executeUpdate();
    }
        }