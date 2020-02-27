package kids.project.tests;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import kids.project.entities.administrateur;
import kids.project.entities.chauffeur;
import kids.project.entities.maitre;
import kids.project.entities.parent;
import kids.project.entities.personne;
import kids.project.services.service_bcrypt;
import kids.project.services.services_personne;
import kids.project.utils.StaticVariables;

public class test {

    public static void main(String[] args) {

        services_personne ser = new services_personne();
        personne p1 = new personne("mariem21", "123", " manai", "mariem", "13015090", "20147789", "Parent");
        parent p2 = new parent("mariem212121", "123", " manai", "mariem", "13015090", "20147789", "Parent");
        chauffeur ch1 = new chauffeur("sayda22", "455", " khechine", " sayda",  "13015091", "20141339", "Chauffeur");
        administrateur a1 = new administrateur("youssef23", "789", " mimouni", " youssef" ,"13015092", "20148989", "Admin");
        maitre m1 = new maitre("rihem24", "147", " dhahmen", "rihem", "13015093", "20147783", "Maitre");
        maitre m2 = new maitre("yosr", "147", " yosrr", "yosrr", "13015093", "20147783", "Maitre");

        try {
           // ser.ajouter1(p1);
           // String p =ser.Mdp("mariem21");
          System.out.println(ser.getTel("mariem21") );
////se
            //ser.ajouter1(ch1);
           // ser.ajouter1(a1);
           // ser.ajouter1(m2);
            ser.readName(1);
////            ser.delete(p2);
          //  ser.Inscription(p2);
               //System.out.println("Liste des utilisateurs :" + ser.connexion("mariem21"));
              //System.out.println("Liste des utilisateurs :" + ser.Mdp("mariem21"));
              System.out.println( ser.readName(1));
              System.out.println( ser.readName(3));
             //System.out.println( ser.readEnf (137 ));
              
             //  int nbre = ser.tentatives(5347629);
           //   System.out.println(nbre);
//            List<personne> list = ser.readAll();
//            System.out.println("Liste des utilisateurs :" + list);
//
//            List<parent> listP = ser.readAllParent();
//            System.out.println("Liste des Parents :" + listP);
//
//            List<chauffeur> listC = ser.readAllChauffeur();
//            System.out.println("Liste des chauffeurs :" + listC);
//
//            List<maitre> listM = ser.readAllMaitre();
//            System.out.println("Liste des maitres :" + listM);
//
//
//                   List<personne> list5 = ser.chercherPer("m");
//            System.out.println("Les utilisateurs :" + list5);
////
//            if (ser.Authentification("mariem21", "123")) {
//                System.out.println("connexion en cours ....");
//            } else {
//                System.out.println("connexion echouéeé");
//            }
//            
//            if (ser.checkUser("mariem21", "123")) {
//                System.out.println("password correct");
//            } else {
//                System.out.println("password error");
//            }
//            
//            if (ser.checkUser("mariem21", "123jfjhf")) {
//                System.out.println("password correct");
//            } else {
//                System.out.println("password error");
//            }

//            if (ser.modifierNomPrenom(p1, "1111", "222")) {
//                System.out.println("personne modifiée");
//            } else {
//                System.out.println("personne non modifiée");
//            }
//            if (ser.modifierPersonne(ch1, "1111", "222","858", "222","1111", "222","1111")) {
//                System.out.println("personne modifiée");
//            } else {
//                System.out.println("personne non modifiée");
//            }
            
//             String crypted = service_bcrypt.hashpw("$2a$10$OYty/sJuxGPcgxtIKQHiWeGfvB/iocrlLp3/o2qDV5t0hMT1v/I3S", StaticVariables.SALT);
//               System.out.println(crypted);
             
////
//            ser.delete(ch1);
//            if (ser.delete(m1)) {
//                System.out.println("personne supprimée");
//            } else {
//                System.out.println("erreur");
//            }
//            System.out.println("Liste des utilisateurs triés par Nom :" + ser.triParNom());
//                  Random r = new Random();
//              int valeur = 50000 + r.nextInt(9);
//              System.out.println(valeur);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
