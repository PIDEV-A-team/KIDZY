package kids.project.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import kids.project.IService.IService;
import kids.project.entities.chauffeur;
import kids.project.entities.enfant;
import kids.project.entities.maitre;
import kids.project.entities.parent;
import kids.project.entities.personne;
import kids.project.utils.DataBase;
import kids.project.utils.StaticVariables;

public class services_personne implements IService<personne> {

    private Connection con;
    private Statement ste;

    public services_personne() {
        con = DataBase.getInstance().getConnection();
    }

//    @Override
//    public void Inscription(parent p) throws SQLException {
//        PreparedStatement pre = con.prepareStatement("INSERT INTO `kidzy`.`user` ( `username`, `password`, `nom`, `prenom`, `cin`, `tel`, `roles`) VALUES ( ?,?,?,?,?,?,?);");
//        pre.setString(1, p.getUsername());
//        String crypted = service_bcrypt.hashpw(p.getPassword(), StaticVariables.SALT);
//
//        pre.setString(2, crypted);
//        pre.setString(3, p.getNom());
//        pre.setString(4, p.getPrenom());
//      
//        pre.setString(6, p.getCin());
//        pre.setString(7, p.getTel());
//        pre.setString(8, "Parent");
//        pre.executeUpdate();
//    }
    public personne get_user_by_id(int id) throws SQLException{
        String req = "select * from user where id="+id;
        ResultSet rs = ste.executeQuery(req);
        personne per =new personne();
        while (rs.next()) {

            per.setUsername(rs.getString("id"));
            per.setUsername(rs.getString("username"));
            per.setPassword(rs.getString("password"));
            per.setNom(rs.getString("nom"));
            per.setPrenom(rs.getString("prenom"));

            per.setCin(rs.getString("cin"));
            per.setTel(rs.getString("tel"));
            per.setRole(rs.getString("roles"));

        }
        return per;
    }
    @Override
    public void ajouter1(personne p) throws SQLException {
        Random r = new Random();
        int valeur = 1 + r.nextInt(10000000);
        String crypted = service_bcrypt.hashpw(p.getPassword(), StaticVariables.SALT);

        PreparedStatement pre = con.prepareStatement("INSERT INTO `kidzy`.`user` ( `username`, `password`, `nom`, `prenom`,`cin`, `tel`, `roles`,`code`,`tentative`) VALUES ( ?,?,?,?,?,?,?,?,6);");
        pre.setString(1, p.getUsername());

        pre.setString(2, crypted);
        pre.setString(3, p.getNom());
        pre.setString(4, p.getPrenom());
        pre.setString(5, p.getCin());
        pre.setString(6, p.getTel());
        pre.setString(7, p.getRole());
        pre.setInt(8, valeur);

        pre.executeUpdate();

    }

    public boolean checkUser(String username, String password) {

        try {
            PreparedStatement pt = con.prepareStatement("SELECT * FROM user where username=?");
            pt.setString(1, username);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                String crypted = rs.getString("password");
                if (service_bcrypt.checkpw(password, crypted)) {
                    return true;
                }
            }
            return false;

        } catch (SQLException e) {
            return false;
        }
    }

    public boolean checkCode(int code) {

        try {
            PreparedStatement pt = con.prepareStatement("SELECT * FROM user where code=?");
            pt.setInt(1, code);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {

                return true;

            }
            return false;

        } catch (SQLException e) {
            return false;
        }
    }

    public personne connexion(String username) throws SQLException {
        personne per = new personne();
        PreparedStatement pt = con.prepareStatement("SELECT * FROM user where username=?");
        pt.setString(1, username);
        ResultSet rs = pt.executeQuery();
        while (rs.next()) {

            per.setUsername(rs.getString("id"));
            per.setUsername(rs.getString("username"));
            per.setPassword(rs.getString("password"));
            per.setNom(rs.getString("nom"));
            per.setPrenom(rs.getString("prenom"));

            per.setCin(rs.getString("cin"));
            per.setTel(rs.getString("tel"));
            per.setRole(rs.getString("roles"));

        }
        return per;
    }

    public int Mdp(String username) throws SQLException {
        int pass = 0;
        PreparedStatement pt = con.prepareStatement("SELECT code FROM user where username=?");
        pt.setString(1, username);

        ResultSet rs = pt.executeQuery();
        while (rs.next()) {

            pass = rs.getInt("code");

        }

        return pass;
    }
    public String getTel(String username) throws SQLException {
        String pass = null;
        PreparedStatement pt = con.prepareStatement("SELECT tel FROM user where username=?");
        pt.setString(1, username);

        ResultSet rs = pt.executeQuery();
        while (rs.next()) {

            pass = rs.getString("tel");

        }

        return pass;
    }
    public int IDU(String username) throws SQLException {
        int pass = 0;
        PreparedStatement pt = con.prepareStatement("SELECT id FROM user where username=?");
        pt.setString(1, username);

        ResultSet rs = pt.executeQuery();
        while (rs.next()) {

            pass = rs.getInt("id");

        }

        return pass;
    }

    public int tentatives(String username ) throws SQLException {
        int pass = 0;
        PreparedStatement pt = con.prepareStatement("SELECT tentative FROM user where username =?");
        pt.setString(1, username);

        ResultSet rs = pt.executeQuery();
        while (rs.next()) {

            pass = rs.getInt("tentative");

        }

        return pass;
    }
    public int idEnfant(String username ) throws SQLException {
        int pass = 0;
        PreparedStatement pt = con.prepareStatement("SELECT tentative FROM user where username =?");
        pt.setString(1, username);

        ResultSet rs = pt.executeQuery();
        while (rs.next()) {

            pass = rs.getInt("tentative");

        }

        return pass;
    }
    public ObservableList<enfant>  readEnf(int id  ) throws SQLException {
        ObservableList<enfant> arr = FXCollections.observableArrayList();
        PreparedStatement pt = con.prepareStatement("SELECT id_enfant ,nom_enfant  ,prenom_enfant FROM enfant where id =?");
        pt.setInt(1, id);

        ResultSet rs = pt.executeQuery();
        while (rs.next()) {
            int idd=rs.getInt("id_enfant");
            String nom= rs.getString("nom_enfant");
            String prenom= rs.getString("prenom_enfant");
           
           enfant e=new enfant (idd,nom,prenom);
           
arr.add(e);
        }

        return arr;
    }

    @Override
    public boolean Authentification(String login, String password) throws SQLException {
        ste = con.createStatement();
        String requeteCheck = "select * from user where `username`= '" + login + "'AND `password`= '" + password + "';";
        ResultSet rs = ste.executeQuery(requeteCheck);
        while (rs.next()) {
            return true;
        }
        return false;

    }

    @Override
    public ObservableList<personne> readAll() throws SQLException {
        ObservableList<personne> arr = FXCollections.observableArrayList();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from user ");
        while (rs.next()) {

           int id = rs.getInt("id");
            String login = rs.getString("username");
            String password = rs.getString("password");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
//            String image = rs.getString("image");
            String cin = rs.getString("cin");
            String tel = rs.getString("tel");
            String role = rs.getString("roles");

           // personne p = new personne(login, password, nom, prenom, cin, tel, role);
             personne p = new personne(id, login, password, nom, prenom, cin, tel, role);

            arr.add(p);
        }
        return arr;
    }

    @Override
    public List<parent> readAllParent() throws SQLException {
        List<parent> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from user where `roles`='Parent' ");
        while (rs.next()) {
            int id = rs.getInt("id");
            String login = rs.getString("username");
            String password = rs.getString("password");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            String cin = rs.getString("cin");
            String tel = rs.getString("tel");
            String role = rs.getString("roles");
            parent p = new parent(id, login, password, nom, prenom, cin, tel, role);
            arr.add(p);
        }
        return arr;
    }
//     @Override
//    public List<parent> readAllParent() throws SQLException {
//        List<parent> arr = new ArrayList<>();
//        ste = con.createStatement();
//        ResultSet rs = ste.executeQuery("select * from user where `roles`='Parent' ");
//        while (rs.next()) {
//            int id = rs.getInt("id");
//            String login = rs.getString("username");
//            String password = rs.getString("password");
//            String nom = rs.getString("nom");
//            String prenom = rs.getString("prenom");
//            String image = rs.getString("image");
//            String cin = rs.getString("cin");
//            String tel = rs.getString("tel");
//            String role = rs.getString("roles");
//            parent p = new parent(id, login, password, nom, prenom, image, cin, tel, role);
//            arr.add(p);
//        }
//        return arr;
//    }

    public ObservableList<String> readAllRoles() throws SQLException {

        ObservableList<String> arr = FXCollections.observableArrayList();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select DISTINCT (roles) from user");
        while (rs.next()) {

            String role = rs.getString("roles");
            arr.add(role);
        }
        return arr;
    }
   

    public ObservableList<String> readName(int id) throws SQLException {
String msg="";
        ObservableList<String> arr = FXCollections.observableArrayList();
        ste = con.createStatement();
       PreparedStatement pt = con.prepareStatement("SELECT DISTINCT (u.nom),u.prenom FROM user u ,enfant e ,seance s WHERE u.id=s.id and s.id_classe=e.id_classe and u.roles=\"Maitre\" and e.id_enfant = ?");
       
       pt.setInt(1,id);
       ResultSet rs = pt.executeQuery();
        while (rs.next()) {
            
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            
            msg=nom+" "+prenom+" ";
            arr.add(msg);
        }
        return arr;
    }

    @Override
    public List<maitre> readAllMaitre() throws SQLException {

        List<maitre> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from user where `roles`='Maitre' ");
        while (rs.next()) {

            int id = rs.getInt("id");
            String login = rs.getString("username");
            String password = rs.getString("password");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            String cin = rs.getString("cin");
            String tel = rs.getString("tel");
            String role = rs.getString("roles");
            maitre p = new maitre(id, login, password, nom, prenom, cin, tel, role);

            arr.add(p);
        }
        return arr;
    }

    @Override
    public boolean delete(personne p) throws SQLException {
        ste = con.createStatement();
        String requeteDelete = "delete  from user where `username`= '" + p.getUsername() + "';";
        ste.executeUpdate(requeteDelete);
        return true;

    }

    public boolean deleteP(personne p) throws SQLException {
        ste = con.createStatement();
        PreparedStatement pt = con.prepareStatement("delete  from user where `username`= ?;");
        pt.setString(1, p.getUsername());
        pt.execute();
        return true;

    }

    @Override
    public boolean modifierNomPrenom(personne p, String nom, String prenom) throws SQLException {
        PreparedStatement pt = con.prepareStatement("UPDATE user SET prenom=?,nom=? WHERE username=?");
        pt.setString(1, prenom);
        pt.setString(2, nom);
        pt.setString(3, p.getUsername());
        pt.execute();
        return true;
    }

    public void updateTen(String username, int nbre) throws SQLException {
        PreparedStatement pt = con.prepareStatement("UPDATE user SET tentative=? WHERE username=?");
        pt.setInt(1, nbre);
        pt.setString(2, username);

        pt.execute();

    }
    

    
    public void updatePass(String username,String password) throws SQLException {
        PreparedStatement pt = con.prepareStatement("UPDATE user SET password=? WHERE username=?");
               String crypted = service_bcrypt.hashpw(password, StaticVariables.SALT);

        pt.setString(1, crypted);
        pt.setString(2, username);

        pt.execute();

    }

    public boolean modifierPersonne(personne p, String Username, String Password, String Nom, String Prenom, String Cin, String Tel, String Role) throws SQLException {
        //String crypted = service_bcrypt.hashpw(Password, StaticVariables.SALT);    
        PreparedStatement pt = con.prepareStatement("UPDATE user SET username=?,password=?, nom=?,prenom=?,cin=?,tel=?,roles=? WHERE username=?");

        pt.setString(1, Username);
        pt.setString(2, Password);
        pt.setString(3, Nom);
        pt.setString(4, Prenom);
        pt.setString(5, Cin);
        pt.setString(6, Tel);
        pt.setString(7, Role);
        pt.setString(8, p.getUsername());
        pt.execute();
        return true;

    }

    public boolean modifierProfil(personne p, String Nom, String Prenom, String Cin, String Tel) throws SQLException {

        PreparedStatement pt = con.prepareStatement("UPDATE user SET nom=?,prenom=?,cin=?,tel=? WHERE username=?");
        pt.setString(1, Nom);
        pt.setString(2, Prenom);
        pt.setString(3, Cin);
        pt.setString(4, Tel);
        pt.setString(5, p.getUsername());
        pt.executeUpdate();
        return true;

    }

    @Override
    public ArrayList<personne> chercherPer(String n) throws SQLException {

        ArrayList<personne> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("SELECT * FROM `user` WHERE `username` LIKE '%" + n + "%'");
        while (rs.next()) {

            int id = rs.getInt("id");
            String login = rs.getString("username");
            String password = rs.getString("password");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            String cin = rs.getString("cin");
            String tel = rs.getString("tel");
            String role = rs.getString("roles");
            personne p = new personne(id, login, password, nom, prenom, cin, tel, role);

            arr.add(p);
        }
        return arr;

    }

    @Override
    public ArrayList<personne> triParNom() throws SQLException {
        ArrayList<personne> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from user ");
        while (rs.next()) {
            int id = rs.getInt("id");
            String login = rs.getString("username");
            String password = rs.getString("password");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            String cin = rs.getString("cin");
            String tel = rs.getString("tel");
            String role = rs.getString("roles");
            personne p = new personne(id, login, password, nom, prenom, cin, tel, role);
            arr.add(p);

        }
        Collections.sort(arr, new personne());
        return arr;
    }

    @Override
    public List<chauffeur> readAllChauffeur() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Inscription(parent t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
