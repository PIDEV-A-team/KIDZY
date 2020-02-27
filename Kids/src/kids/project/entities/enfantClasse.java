/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.entities;

/**
 *
 * @author ferjani
 */
public class enfantClasse {
    
    public int id;
    public int id_enfant;
    public String nom_enfant;
    public String prenom_enfant;
    public String image_enfant;
    public String libelle_cla;
    public String dateN_enfant;
    public int id_classe;
   

    public enfantClasse() {
    }

    public enfantClasse(int id_enfant, String nom_enfant, String prenom_enfant, String libelle_cla, String dateN_enfant, int id_classe) {
        this.id_enfant = id_enfant;
        this.nom_enfant = nom_enfant;
        this.prenom_enfant = prenom_enfant;
        this.libelle_cla = libelle_cla;
        this.dateN_enfant = dateN_enfant;
        this.id_classe = id_classe;
    }
    

    public enfantClasse(String nom_enfant, String prenom_enfant,String image , String dateN_enfant, int id_classe) {
        this.nom_enfant = nom_enfant;
        this.prenom_enfant = prenom_enfant;
        this.image_enfant = image;
        this.dateN_enfant = dateN_enfant;
        this.id_classe = id_classe;
    }

    public enfantClasse(String nom_enfant, String prenom_enfant, String image_enfant, String libelle_cla, String dateN_enfant, int id_classe) {
        this.nom_enfant = nom_enfant;
        this.prenom_enfant = prenom_enfant;
        this.image_enfant = image_enfant;
        this.libelle_cla = libelle_cla;
        this.dateN_enfant = dateN_enfant;
        this.id_classe = id_classe;
    }

    public enfantClasse(int id_user,  int id_classe,String nomP, String prenomP, String img, String date) {
        
        this.id = id_user;
        this.id_classe = id_classe;
         this.nom_enfant = nomP;
        this.prenom_enfant = prenomP;
        this.image_enfant = img;
       
        this.dateN_enfant = date;
        
    }
    

   
 
    public String getImage_enfant() {
        return image_enfant;
    }

    public void setImage_enfant(String image_enfant) {
        this.image_enfant = image_enfant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_classe() {
        return id_classe;
    }

    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
    }

    
    public int getId_enfant() {
        return id_enfant;
    }

    public void setId_enfant(int id_enfant) {
        this.id_enfant = id_enfant;
    }

    
    public String getNom_enfant() {
        return nom_enfant;
    }

    public void setNom_enfant(String nom_enfant) {
        this.nom_enfant = nom_enfant;
    }

    public String getPrenom_enfant() {
        return prenom_enfant;
    }

    public void setPrenom_enfant(String prenom_enfant) {
        this.prenom_enfant = prenom_enfant;
    }

    public String getLibelle_cla() {
        return libelle_cla;
    }

    public void setLibelle_cla(String libelle_cla) {
        this.libelle_cla = libelle_cla;
    }

    public String getDateN_enfant() {
        return dateN_enfant;
    }

    public void setDateN_enfant(String dateN_enfant) {
        this.dateN_enfant = dateN_enfant;
    }

    @Override
    public String toString() {
        return "enfantClasse{" + "nom_enfant=" + nom_enfant + ", prenom_enfant=" + prenom_enfant + ", libelle_cla=" + libelle_cla + ", dateN_enfant=" + dateN_enfant + '}';
    }
    
    
    
    
}
