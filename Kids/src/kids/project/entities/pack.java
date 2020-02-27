package kids.project.entities;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class pack {
    private int id_pack;
    private String nom_pack;
    private double prix_pack;
    private String description_pack;
    List<Checkbox> listefrais = new ArrayList<Checkbox>();
    Checkbox cantine ;
    Checkbox garde ;
    Checkbox chauffeur ;

    public pack(String nom_pack, double prix_pack, String description_pack) {
        this.nom_pack = nom_pack;
        this.prix_pack = prix_pack;
        this.description_pack = description_pack;

        this.listefrais.add(cantine);
        this.listefrais.add(chauffeur);
        this.listefrais.add(garde);

    }

    public int getId_pack() {
        return id_pack;
    }

    public void setId_pack(int id_pack) {
        this.id_pack = id_pack;
    }

    public String getNom_pack() {
        return nom_pack;
    }

    public void setNom_pack(String nom_pack) {
        this.nom_pack = nom_pack;
    }

    public double getPrix_pack() {
        return prix_pack;
    }

    public void setPrix_pack(double prix_pack) {
        this.prix_pack = prix_pack;
    }

    public String getDescription_pack() {
        return description_pack;
    }

    public void setDescription_pack(String description_pack) {
        this.description_pack = description_pack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        pack pack = (pack) o;
        return nom_pack.equals(pack.nom_pack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom_pack);
    }

    @Override
    public String toString() {
        return "pack{" +
                "id_pack=" + id_pack +
                ", nom_pack='" + nom_pack + '\'' +
                ", prix_pack=" + prix_pack +
                ", description_pack='" + description_pack + '\'' +
                '}';
    }

    public List<Checkbox> getListefrais() {
        return listefrais;
    }

    public void setListefrais(List<Checkbox> listefrais) {
        this.listefrais = listefrais;
    }
}
