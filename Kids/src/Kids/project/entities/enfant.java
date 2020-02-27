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
public class enfant {

    private int id_enfant;
    private parent parent;
    private classe classe;

    private String nom_enfant;
    private String prenom_enfant;
    private String image_enfant;
    private String dateN_enfant;

    public enfant() {
    }

    public enfant(String nom_enfant, String prenom_enfant) {
        this.nom_enfant = nom_enfant;
        this.prenom_enfant = prenom_enfant;
    }

    public enfant(int id_enfant, parent parent, classe classe, String nom_enfant, String prenom_enfant, String dateN_enfant) {
        this.id_enfant = id_enfant;
        this.parent = parent;
        this.classe = classe;
        this.nom_enfant = nom_enfant;
        this.prenom_enfant = prenom_enfant;
        this.dateN_enfant = dateN_enfant;
    }

    public enfant(parent parent, classe classe, String nom_enfant, String prenom_enfant, String image_enfant, String dateN_enfant) {
        this.parent = parent;
        this.classe = classe;
        this.nom_enfant = nom_enfant;
        this.prenom_enfant = prenom_enfant;
        this.image_enfant = image_enfant;
        this.dateN_enfant = dateN_enfant;
    }
    

    public enfant(String nom_enfant, String prenom_enfant, String image_enfant, String dateN_enfant) {
        this.nom_enfant = nom_enfant;
        this.prenom_enfant = prenom_enfant;
        this.image_enfant = image_enfant;
        this.dateN_enfant = dateN_enfant;
    }
    public enfant(int id_enfant,String nom_enfant, String prenom_enfant, String image_enfant, String dateN_enfant) {
        this.id_enfant = id_enfant;
        this.nom_enfant = nom_enfant;
        this.prenom_enfant = prenom_enfant;
        this.image_enfant = image_enfant;
        this.dateN_enfant = dateN_enfant;
    }
    

    public enfant(classe classe, String nom_enfant, String prenom_enfant, String dateN_enfant) {
        this.classe = classe;
        this.nom_enfant = nom_enfant;
        this.prenom_enfant = prenom_enfant;
        this.dateN_enfant = dateN_enfant;
    }
    

    @Override
    public String toString() {
return " " + nom_enfant +  prenom_enfant ;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + this.id_enfant;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final enfant other = (enfant) obj;
        if (this.id_enfant != other.id_enfant) {
            return false;
        }
        return true;
    }

    public int getId_enfant() {
        return id_enfant;
    }

    public void setId_enfant(int id_enfant) {
        this.id_enfant = id_enfant;
    }

    public parent getParent() {
        return parent;
    }

    public void setParent(parent parent) {
        this.parent = parent;
    }

    public classe getClasse() {
        return classe;
    }

    public void setClasse(classe classe) {
        this.classe = classe;
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

    public String getImage_enfant() {
        return image_enfant;
    }

    public void setImage_enfant(String image_enfant) {
        this.image_enfant = image_enfant;
    }

    public String getDateN_enfant() {
        return dateN_enfant;
    }

    public void setDateN_enfant(String dateN_enfant) {
        this.dateN_enfant = dateN_enfant;
    }
    
    

}
