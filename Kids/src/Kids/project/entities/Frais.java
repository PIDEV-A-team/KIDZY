/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.entities;

/**
 *
 * @author Youssef Mimouni
 */
public class Frais {

    private int id_frais;
    private String titre;
    private Double prix;

    public Frais(String titre, Double prix) {
        super();
        this.titre = titre;
        this.prix = prix;
    }
    
    public Frais(int id , String titre, Double prix) {
        super();
        this.id_frais = id;
        this.titre = titre;
        this.prix = prix;
    }

    public Frais() {
        super();
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public int getId_frais() {
        return id_frais;
    }

    public void setId_frais(int id_frais) {
        this.id_frais = id_frais;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public String toString() {
        return "Frais{" + "id_frais=" + id_frais + ", titre=" + titre + ", prix=" + prix + '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id_frais;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Frais)) {
            return false;
        }
        Frais other = (Frais) obj;
        if (id_frais != other.id_frais) {
            return false;
        }
        return true;
    }
}
