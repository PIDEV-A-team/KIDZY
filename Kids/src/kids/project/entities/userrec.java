/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kids.project.entities;

import java.util.Date;

/**
 *
 * @author admin
 */
public class userrec {

    private int id_rec;
    private String description_rec;
    private String reponse_rec;
    private String nom;
    private String prenom;
    private String etat_rec;
    private Date date_rec;
    private String archive;

    public userrec() {
    }

  
    @Override
    public String toString() {
        return "userrec{" + "id_rec=" + id_rec + ", description_rec=" + description_rec + ", reponse_rec=" + reponse_rec + ", nom=" + nom + ", prenom=" + prenom + ", etat_rec=" + etat_rec + ", date_rec=" + date_rec + ", archive=" + archive + '}';
    }

    public void setArchive(String archive) {
        this.archive = archive;
    }

    public String getArchive() {
        return archive;
    }

    public userrec(int id_rec, String description_rec, String reponse_rec, String nom, String prenom, String etat_rec, Date date_rec, String archive) {
        this.id_rec = id_rec;
        this.description_rec = description_rec;
        this.reponse_rec = reponse_rec;
        this.nom = nom;
        this.prenom = prenom;
        this.etat_rec = etat_rec;
        this.date_rec = date_rec;
        this.archive = archive;
    }



    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id_rec;
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
        final userrec other = (userrec) obj;
        if (this.id_rec != other.id_rec) {
            return false;
        }
        return true;
    }

    public userrec(int id_rec, Date date_rec, String etat_rec, String description_rec, String nom, String prenom) {
        this.id_rec = id_rec;
        this.date_rec = date_rec;
        this.etat_rec = etat_rec;
        this.description_rec = description_rec;
        this.nom = nom;
        this.prenom = prenom;
    }

    public void setId_rec(int id_rec) {
        this.id_rec = id_rec;
    }

    public void setDate_rec(Date date_rec) {
        this.date_rec = date_rec;
    }

    public void setEtat_rec(String etat_rec) {
        this.etat_rec = etat_rec;
    }

    public void setDescription_rec(String description_rec) {
        this.description_rec = description_rec;
    }

    public void setReponse_rec(String reponse_rec) {
        this.reponse_rec = reponse_rec;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getId_rec() {
        return id_rec;
    }

    public Date getDate_rec() {
        return date_rec;
    }

    public String getEtat_rec() {
        return etat_rec;
    }

    public String getDescription_rec() {
        return description_rec;
    }

    public String getReponse_rec() {
        return reponse_rec;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public userrec(int id_rec, Date date_rec, String etat_rec, String description_rec, String reponse_rec, String nom, String prenom) {
        this.id_rec = id_rec;
        this.date_rec = date_rec;
        this.etat_rec = etat_rec;
        this.description_rec = description_rec;
        this.reponse_rec = reponse_rec;
        this.nom = nom;
        this.prenom = prenom;
    }

}
