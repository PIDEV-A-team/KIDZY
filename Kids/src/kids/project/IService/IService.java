/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.IService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import kids.project.entities.chauffeur;
import kids.project.entities.maitre;
import kids.project.entities.parent;
import kids.project.entities.personne;

/**
 *
 * @author House
 */
public interface IService<T> {

    void Inscription(parent t) throws SQLException;

    void ajouter1(T t) throws SQLException;

    boolean Authentification(String a, String b) throws SQLException;

    ObservableList<T> readAll() throws SQLException;

    List<parent> readAllParent() throws SQLException;

    List<chauffeur> readAllChauffeur() throws SQLException;

    List<maitre> readAllMaitre() throws SQLException;

    boolean delete(T t) throws SQLException;

    boolean modifierNomPrenom(T t, String a, String b) throws SQLException;

     List<T> chercherPer(String b) throws SQLException;

    ArrayList<T> triParNom() throws SQLException;
}
