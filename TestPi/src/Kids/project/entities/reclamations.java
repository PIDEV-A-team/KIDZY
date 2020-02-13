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
public class reclamations {
    private int id_rec;
    private Date date_rec;
    private byte etat_rec;
    private String description_rec;
    private String reponse_rec;

    public reclamations(int id_rec, Date date_rec, byte etat_rec, String description_rec, String reponse_rec) {
        this.id_rec = id_rec;
        this.date_rec = date_rec;
        this.etat_rec = etat_rec;
        this.description_rec = description_rec;
        this.reponse_rec = reponse_rec;
        
           
    }

    public reclamations(Date date_rec, byte etat_rec, String description_rec, String reponse_rec) {
        this.date_rec = date_rec;
        this.etat_rec = etat_rec;
        this.description_rec = description_rec;
        this.reponse_rec = reponse_rec;
    }

    public reclamations(int id_rec) {
        this.id_rec = id_rec;
    }

    public reclamations() {
    }




    public int getId_rec() {
        return id_rec;
    }

    public Date getDate_rec() {
        return date_rec;
    }

    public byte getEtat_rec() {
        return etat_rec;
    }

    public String getDescription_rec() {
        return description_rec;
    }

    public String getReponse_rec() {
        return reponse_rec;
    }

    public void setId_rec(int id_rec) {
        this.id_rec = id_rec;
    }

    public void setDate_rec(Date date_rec) {
        this.date_rec = date_rec;
    }

    public void setEtat_rec(byte etat_rec) {
        this.etat_rec = etat_rec;
    }

    public void setDescription_rec(String description_rec) {
        this.description_rec = description_rec;
    }

    public void setReponse_rec(String reponse_rec) {
        this.reponse_rec = reponse_rec;
    }

    @Override
    public String toString() {
        return "reclamations{" + "id_rec=" + id_rec + ", date_rec=" + date_rec + ", etat_rec=" + etat_rec + ", description_rec=" + description_rec + ", reponse_rec=" + reponse_rec + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.id_rec;
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
        final reclamations other = (reclamations) obj;
        if (this.id_rec != other.id_rec) {
            return false;
        }
        return true;
    }
        
          
 
    
}
    

