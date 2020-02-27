/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.entities;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class event  implements Comparator<event>{
    private int id_event;
    private String nom_event;
    private String date_event;
    private double prix_event;
    private String desc_event;
    private String type_event;
    private String lieu_event;

    public event() {
    }
    

    public event(int id_event, String nom_event, String date_event, double prix_event, String desc_event, String type_event, String lieu_event) {
        this.id_event = id_event;
        this.nom_event = nom_event;
        this.date_event = date_event;
        this.prix_event = prix_event;
        this.desc_event = desc_event;
        this.type_event = type_event;
        this.lieu_event = lieu_event;
    }
    public event( String nom_event, String date_event, double prix_event) {
         this.nom_event = nom_event;
        this.date_event = date_event;
        this.prix_event = prix_event;
    }

    public event(String nom_event, String date_event, double prix_event, String desc_event, String type_event, String lieu_event) {
        this.nom_event = nom_event;
        this.date_event = date_event;
        this.prix_event = prix_event;
        this.desc_event = desc_event;
        this.type_event = type_event;
        this.lieu_event = lieu_event;
    }     

    public event(String nom_event) {
                this.nom_event = nom_event;

    }

    public event(String nom_event, String date_event, String prix_event, String descr_event, String type_event, String lieu_event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public event(String text, String text0, String text1, String text2, String text3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    

        
    public int getId_event() {
        return id_event;
    }

    public String getNom_event() {
        return nom_event;
    }

    public String getDate_event() {
        return date_event;
    }

    public double getPrix_event() {
        return prix_event;
    }

    public String getDesc_event() {
        return desc_event;
    }

    public String getType_event() {
        return type_event;
    }

    public String getLieu_event() {
        return lieu_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public void setNom_event(String nom_event) {
        this.nom_event = nom_event;
    }

    public void setDate_event(String date_event) {
        this.date_event = date_event;
    }

    public void setPrix_event(float prix_event) {
        this.prix_event = prix_event;
    }

    public void setDesc_event(String desc_event) {
        this.desc_event = desc_event;
    }

    public void setType_event(String type_event) {
        this.type_event = type_event;
    }

    public void setLieu_event(String lieu_event) {
        this.lieu_event = lieu_event;
    }

    @Override
    public String toString() {
        return "event{" + "id_event=" + id_event + ", nom_event=" + nom_event + ", date_event=" + date_event + ", prix_event=" + prix_event + ", desc_event=" + desc_event + ", type_event=" + type_event + ", lieu_event=" + lieu_event + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id_event;
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
        final event other = (event) obj;
        if (this.id_event != other.id_event) {
            return false;
        }
        return true;
    }

    @Override
    public int compare(event o1, event o2) {
  return (o1.getNom_event().compareTo(o2.getNom_event()));    }

   

   
 
    
    
            
}
